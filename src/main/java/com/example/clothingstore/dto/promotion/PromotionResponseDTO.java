package com.example.clothingstore.dto.promotion;

import java.time.LocalDateTime;
import java.util.List;

import com.example.clothingstore.dto.discount.DiscountResponseDTO;
import com.example.clothingstore.dto.gift.GiftResponseDTO;
import com.example.clothingstore.dto.promotiongroup.PromotionGroupResponseDTO;
import com.example.clothingstore.enums.PromotionTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionResponseDTO {

    private Integer promotionId;

    private String promotionName;

    private PromotionTypeEnum promotionType;

    private String description;

    // private String applyCondition;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    // private String applyType;

    private List<PromotionGroupResponseDTO> promotionGroupResponseDTOs;

    private DiscountResponseDTO discountResponseDTO;

    private List<GiftResponseDTO> giftResponseDTOs;
}
