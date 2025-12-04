package com.example.clothingstore.dto.productdetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailUpdateDTO {

    private Integer detailId;

    private String size;

    private Integer quantity;

}
