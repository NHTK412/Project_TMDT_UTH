package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.promotion.PromotionRequestDTO;
import com.example.clothingstore.dto.promotion.PromotionResponseDTO;
import com.example.clothingstore.service.PromotionService;
import com.example.clothingstore.util.ApiResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/admin/promotion")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/{promotionId}")
    public ResponseEntity<ApiResponse<PromotionResponseDTO>> getPromotionById(@PathVariable Integer promotionId) {

        PromotionResponseDTO promotionResponseDTO = promotionService.getPromotionById(promotionId);

        return ResponseEntity.ok(new ApiResponse<PromotionResponseDTO>(true, null, promotionResponseDTO));
    }

    @PostMapping
    public ResponseEntity<ApiResponse<PromotionResponseDTO>> createPromotion(
            @RequestBody PromotionRequestDTO promotionRequestDTO) {

        PromotionResponseDTO promotionResponseDTO = promotionService.createPromotion(promotionRequestDTO);

        // PromotionResponseDTO promotionResponseDTO = null;

        return ResponseEntity.ok(new ApiResponse<PromotionResponseDTO>(true, null, promotionResponseDTO));
    }

}
