package com.example.clothingstore.dto.productcolor;

import java.util.List;

import com.example.clothingstore.dto.productdetail.ProductDetailRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductColorRequestDTO {
    private String color;

    private String productImage;

    private List<ProductDetailRequestDTO> productDetails;
}
