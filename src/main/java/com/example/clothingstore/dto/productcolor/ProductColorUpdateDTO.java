package com.example.clothingstore.dto.productcolor;

import java.util.List;

import com.example.clothingstore.dto.productdetail.ProductDetailRequestDTO;
import com.example.clothingstore.dto.productdetail.ProductDetailUpdateDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductColorUpdateDTO {

    private Integer colorId;

    private String color;

    private String productImage;

    private List<ProductDetailUpdateDTO> productDetails;
}
