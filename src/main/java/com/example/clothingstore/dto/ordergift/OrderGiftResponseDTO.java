package com.example.clothingstore.dto.ordergift;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderGiftResponseDTO {

    private String giftName;

    private Integer giftQuantity;

    private String giftImage;

    private String promotionName;

}
