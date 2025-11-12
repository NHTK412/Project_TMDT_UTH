package com.example.clothingstore.dto.cartdetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDetailRequestDTO {

    private Integer productDetailId;

    private Integer quantity;

}
