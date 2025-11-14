package com.example.clothingstore.dto.promotiongroup;

import java.util.List;
import java.util.Map;

import com.example.clothingstore.dto.product.ProductPromotionDTO;
import com.example.clothingstore.dto.productdetail.ProductDetailPromotionDTO;
import com.example.clothingstore.dto.productdetail.ProductDetailResponseDTO;
import com.example.clothingstore.dto.productvariant.ProductVariantGroupDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PromotionGroupResponseDTO {

    private Integer groupId;

    private String groupName;

    private String description;

    private Integer minPurchaseQuantity;

    private List<ProductPromotionDTO> productPromotionDTOs;

    // private Map<Integer, Map<Integer, List<ProductDetailResponseDTO>>>
    // groupedProductDetails;

    // private List<ProductVariantGroupDTO> productVariantGroupDTOs;

    // private List<ProductResponseDTO> productResponseDTOs;

}
