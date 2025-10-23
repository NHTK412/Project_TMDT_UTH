package com.example.clothingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.ProductResponseDTO;
import com.example.clothingstore.dto.ProductSummaryDTO;
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

    public List<ProductSummaryDTO> getAllProduct(Integer categoryId, Pageable pageable) {
        Page<Product> products = (categoryId == null) ? productRepository.findAll(pageable)
                : productRepository.findByCategories_CategoryId(categoryId, pageable);

        List<ProductSummaryDTO> productSummaryDTOs = products.toList()
                .stream()
                .map((product) -> {
                    return new ProductSummaryDTO(product);
                })
                .toList();

        return productSummaryDTOs;
    }
}
