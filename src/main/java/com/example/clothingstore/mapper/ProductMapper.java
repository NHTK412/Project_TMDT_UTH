package com.example.clothingstore.mapper;

import com.example.clothingstore.dto.product.ProductSummaryDTO;
import com.example.clothingstore.model.Product;

public class ProductMapper {

    public static ProductSummaryDTO convertModelToProductSummaryDTO(Product product) {
        ProductSummaryDTO productSummaryDTO = new ProductSummaryDTO();

        productSummaryDTO.setProductId(product.getProductId());

        productSummaryDTO.setProductName(product.getProductName());

        productSummaryDTO.setUnitPrice(product.getUnitPrice());

        productSummaryDTO.setDescription(product.getDescription());

        productSummaryDTO.setProductImage(product.getProductImage());

        return productSummaryDTO;
    }
}
