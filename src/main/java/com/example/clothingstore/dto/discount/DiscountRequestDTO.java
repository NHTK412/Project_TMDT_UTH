package com.example.clothingstore.dto.discount;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DiscountRequestDTO {

    private Double discountPercentage;

    private Double discountAmount;

    private Double maxDiscount;

}
