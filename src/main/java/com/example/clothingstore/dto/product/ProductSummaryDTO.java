package com.example.clothingstore.dto.product;

import java.util.List;

import com.example.clothingstore.dto.productcolor.ProductColorResponseDTO;
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

    private Double discount;

    private String description;

    private String productImage;

    private List<ProductColorResponseDTO> productColors;

    public ProductSummaryDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.unitPrice = product.getUnitPrice();
        this.description = product.getDescription();
        this.productImage = product.getProductImage();
        this.discount = product.getDiscount();
        this.productColors = product.getProductColors()
                .stream()
                .map((productColor) -> {
                    return new ProductColorResponseDTO(productColor);
                })
                .toList();
    }
}
