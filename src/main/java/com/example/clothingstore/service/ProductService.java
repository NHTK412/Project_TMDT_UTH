package com.example.clothingstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.ProductResponseDTO;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.model.Product;
import com.example.clothingstore.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public ProductResponseDTO getProductDetailById(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Invalid product code"));
        return new ProductResponseDTO(product);
    }
}
