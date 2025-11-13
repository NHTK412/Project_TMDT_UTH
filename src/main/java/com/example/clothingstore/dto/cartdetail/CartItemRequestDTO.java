package com.example.clothingstore.dto.cartdetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemRequestDTO {

    private Integer productDetailId;

    private Integer quantity;

    // private Boolean isSelect;

}
