package com.example.clothingstore.dto;

import java.util.List;

import com.example.clothingstore.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Integer productId;

    private String productName;

    private Double unitPrice;

    private String description;

    private String productImage;

    private List<ProductDetailResponseDTO> productDetails;

    private List<ReviewResponseDTO> reviews;

    public ProductResponseDTO(Product product) {
        this.productId = product.getProductId();
        this.productName = product.getProductName();
        this.unitPrice = product.getUnitPrice();
        this.description = product.getDescription();
        this.productImage = product.getProductImage();
        this.productDetails = product.getProductDetails()
                .stream()
                .map((productDetail) -> {
                    return new ProductDetailResponseDTO(productDetail);
                })
                .toList();
        this.reviews = product.getReviews()
                .stream()
                .map((review) -> {
                    return new ReviewResponseDTO(review);
                })
                .toList();
    }
}
