package com.example.clothingstore.dto.promotiongroup;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionGroupRequestDTO {
    private String groupName;

    private String description;

    private Integer minPurchaseQuantity;

    private List<Integer> productDetailIds;
}
