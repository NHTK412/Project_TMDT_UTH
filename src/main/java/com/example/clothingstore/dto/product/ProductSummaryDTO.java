package com.example.clothingstore.dto.product;

import com.example.clothingstore.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSummaryDTO {
    private Integer productId;

    private String productName;

    private Double unitPrice;

    private String description;

    private String productImage;

    public ProductSummaryDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.unitPrice = product.getUnitPrice();
        this.description = product.getDescription();
        this.productImage = product.getProductImage();
    }
}
