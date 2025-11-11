package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.review.ReviewRequestDTO;
import com.example.clothingstore.dto.review.ReviewResponseDTO;
import com.example.clothingstore.service.ReviewService;
import com.example.clothingstore.util.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/product/{productId}/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ReviewResponseDTO>>> getALLReviewByProductId(
            @PathVariable Integer productId, @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size) {

        Pageable pageable = PageRequest.of(page - 1, size);
        List<ReviewResponseDTO> reviewResponseDTOs = reviewService.getALLReviewByProductId(productId, pageable);

        return ResponseEntity.ok(new ApiResponse<List<ReviewResponseDTO>>(true, null, reviewResponseDTOs));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> createReviewByProductId(@PathVariable Integer productId,
            ReviewRequestDTO reviewRequestDTO) {

        ReviewResponseDTO reviewResponseDTO = reviewService.createReviewByProductId(productId, reviewRequestDTO);

        return ResponseEntity.ok(new ApiResponse<ReviewResponseDTO>(true, null, reviewResponseDTO));
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> updateReview(@PathVariable Integer productId,
            @PathVariable Integer reviewId,
            ReviewRequestDTO reviewRequestDTO) {

        ReviewResponseDTO reviewResponseDTO = reviewService.updateReview(productId, reviewId, reviewRequestDTO);

        return ResponseEntity.ok(new ApiResponse<ReviewResponseDTO>(true, null, reviewResponseDTO));
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<ApiResponse<ReviewResponseDTO>> deleteReview(@PathVariable Integer productId,
            @PathVariable Integer reviewId) {

        ReviewResponseDTO reviewResponseDTO = reviewService.deleteReview(productId, reviewId);

        return ResponseEntity.ok(new ApiResponse<ReviewResponseDTO>(true, null, reviewResponseDTO));
    }

}
