package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.ProductResponseDTO;
import com.example.clothingstore.service.ProductService;
import com.example.clothingstore.util.ApiResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("product")
public class ProductController {

    // @GetMapping
    // public getMethodName(@RequestParam String param) {
    // return new String();
    // }

    @Autowired
    ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductResponseDTO>> getProductDetailById(@PathVariable Integer productId) {
        ProductResponseDTO productResponseDTO = productService.getProductDetailById(productId);
        return ResponseEntity.ok(new ApiResponse<ProductResponseDTO>(true, null, productResponseDTO));
    }

}
