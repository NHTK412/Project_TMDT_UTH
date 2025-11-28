package com.example.clothingstore.dto.promotion;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.example.clothingstore.enums.PromotionTypeEnum;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionSummaryDTO {
    private Integer promotionId;

    private String promotionName;

    private PromotionTypeEnum promotionType;

    private String description;

    // private String applyCondition;

    private LocalDateTime startDate;

    private LocalDateTime endDate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discountAmount;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double discountPercentage;
}
