package com.example.clothingstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.promotion.PromotionRequestDTO;
import com.example.clothingstore.dto.promotion.PromotionResponseDTO;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.mapper.PromotionMapper;
import com.example.clothingstore.model.Promotion;
import com.example.clothingstore.repository.PromotionRepository;

@Service
public class PromotionService {

    @Autowired
    private PromotionRepository promotionRepository;

    @Autowired
    private PromotionMapper promotionMapper;

    public PromotionResponseDTO getPromotionById(Integer promotionId) {
        Promotion promotion = promotionRepository.findById(promotionId)
                .orElseThrow(() -> new NotFoundException("Invalue Promotion Code"));

        return promotionMapper.convertModelToPromotionResponseDTO(promotion);
    }

    public PromotionResponseDTO createPromotion(PromotionRequestDTO promotionRequestDTO) {
        return null;
    }
}
