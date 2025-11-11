package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.review.ReviewRequestDTO;
import com.example.clothingstore.dto.review.ReviewResponseDTO;
import com.example.clothingstore.service.ReviewService;
import com.example.clothingstore.util.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/review")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<List<ReviewResponseDTO>>> getALLReviewByProductId(
            @RequestParam Integer productId) {
        // return new String();
        List<ReviewResponseDTO> responseDTOs = reviewService.getALLReviewByProductId(productId);

        return ResponseEntity.ok(new ApiResponse<List<ReviewResponseDTO>>(true, null, responseDTOs));
    }

    @PostMapping("/{productId}")
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> createReviewByProductId(@RequestParam Integer productId,
            ReviewRequestDTO reviewRequestDTO) {
        // return new String();

        ReviewResponseDTO responseDTO = reviewService.createReviewByProductId(productId, reviewRequestDTO);

        return ResponseEntity.ok(new ApiResponse<ReviewResponseDTO>(true, null, responseDTO));
    }

    @PutMapping("/{productId}/{reviewId}")
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> updateReview(@RequestParam Integer productId,
            @RequestParam Integer reviewId,
            ReviewRequestDTO reviewRequestDTO) {
        // return new String();

        ReviewResponseDTO responseDTO = reviewService.updateReview(productId, reviewId, reviewRequestDTO);

        return ResponseEntity.ok(new ApiResponse<ReviewResponseDTO>(true, null, responseDTO));
    }

}
