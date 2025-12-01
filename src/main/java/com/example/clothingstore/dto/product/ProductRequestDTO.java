package com.example.clothingstore.dto.product;

import java.util.List;

import com.example.clothingstore.dto.productcolor.ProductColorRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequestDTO {

    private String productName;

    private Double unitPrice;

    private String description;

    private String productImage;

    private Double discount;

    private List<Integer> categoryId; // Dùng để gắn danh mục

    private List<ProductColorRequestDTO> productColors;

}
