package com.example.clothingstore.dto.promotion;

import java.time.LocalDateTime;
import java.util.List;

import com.example.clothingstore.dto.discount.DiscountRequestDTO;
import com.example.clothingstore.dto.gift.GiftRequestDTO;
import com.example.clothingstore.dto.promotiongroup.PromotionGroupRequestDTO;
import com.example.clothingstore.enums.PromotionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionRequestDTO {

    private String promotionName;

    private PromotionTypeEnum promotionType;

    private String description;

    // private String applyCondition;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    // private String applyType;

    private List<PromotionGroupRequestDTO> promotionGroupRequestDTOs;

    private DiscountRequestDTO discountRequestDTO;

    private List<GiftRequestDTO> giftRequestDTOs;
}
