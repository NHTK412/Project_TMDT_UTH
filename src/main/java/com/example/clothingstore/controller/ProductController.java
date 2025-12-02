package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.product.ProductRequestDTO;
import com.example.clothingstore.dto.product.ProductResponseDTO;
import com.example.clothingstore.dto.product.ProductSummaryDTO;
import com.example.clothingstore.service.ProductService;
import com.example.clothingstore.util.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    ProductService productService;

    // @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductDetailById(@PathVariable Integer productId) {
        ProductResponseDTO productResponseDTO = productService.getProductDetailById(productId);

        return ResponseEntity.ok(new ApiResponse<ProductResponseDTO>(true, null, productResponseDTO));
    }

    // @PreAuthorize("hasAnyRole('ADMIN', 'CUSTOMER')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<ProductSummaryDTO>>> getAllProduct(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "10") Integer size, @RequestParam(required = false) Integer categoryId) {

        Pageable pageable = PageRequest.of(page - 1, size);

        List<ProductSummaryDTO> productSummaryDTOs = productService.getAllProduct(categoryId, pageable);

        return ResponseEntity.ok(new ApiResponse<List<ProductSummaryDTO>>(true, null, productSummaryDTOs));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<ProductSummaryDTO>> createProduct(@RequestBody ProductRequestDTO productRequest) {
        return ResponseEntity
                .ok(new ApiResponse<ProductSummaryDTO>(true, null,
                        productService.createProduct(productRequest)));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductSummaryDTO>> deleteProduct(@PathVariable Integer productId) {
        ProductSummaryDTO productSummaryDTO = productService.deleteProduct(productId);

        return ResponseEntity.ok(new ApiResponse<ProductSummaryDTO>(true, null, productSummaryDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductSummaryDTO>> updateProduct(@PathVariable Integer productId,
            @RequestBody ProductRequestDTO productRequest) {
        return ResponseEntity
                .ok(new ApiResponse<ProductSummaryDTO>(true, null,
                        productService.updateProduct(productId, productRequest)));
    }
}
