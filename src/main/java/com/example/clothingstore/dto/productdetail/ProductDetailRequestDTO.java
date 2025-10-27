package com.example.clothingstore.dto.productdetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailRequestDTO {

    // private String color; --> Bỏ vì bên ProductColor có rồi

    private String size;

    private Integer quantity;

    // private String productImage;

}
