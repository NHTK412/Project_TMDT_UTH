package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.ProductResponseDTO;
import com.example.clothingstore.dto.ProductSummaryDTO;
import com.example.clothingstore.service.ProductService;
import com.example.clothingstore.util.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductDetailById(@PathVariable Integer productId) {
        ProductResponseDTO productResponseDTO = productService.getProductDetailById(productId);
        return ResponseEntity.ok(new ApiResponse<ProductResponseDTO>(true, null, productResponseDTO));
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductSummaryDTO>>> getAllProduct(@RequestParam Integer page,
            @RequestParam Integer size, @RequestParam(required = false) Integer categoryId) {

        Pageable pageable = PageRequest.of(page - 1, size);
        List<ProductSummaryDTO> productSummaryDTOs = productService.getAllProduct(categoryId, pageable);

        return ResponseEntity.ok(new ApiResponse<List<ProductSummaryDTO>>(true, null, productSummaryDTOs));
    }

}
