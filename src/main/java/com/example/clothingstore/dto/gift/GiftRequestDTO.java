package com.example.clothingstore.dto.gift;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GiftRequestDTO {
    private Integer giftQuantity;

    private Integer maxGift;

    private Integer productDetailId;
}
