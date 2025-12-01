package com.example.clothingstore.dto.productcolor;

import java.util.List;

import com.example.clothingstore.dto.productdetail.ProductDetailPromotionDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductColorPromotionDTO {
    private Integer colorId;
    private String color;
    private String colorImage;

    private List<ProductDetailPromotionDTO> productDetails;

}
