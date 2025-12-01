package com.example.clothingstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;

import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.product.ProductRequestDTO;
import com.example.clothingstore.dto.product.ProductResponseDTO;
import com.example.clothingstore.dto.product.ProductSummaryDTO;
import com.example.clothingstore.dto.productcolor.ProductColorRequestDTO;
import com.example.clothingstore.dto.productdetail.ProductDetailRequestDTO;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.model.Category;
import com.example.clothingstore.model.Product;
import com.example.clothingstore.model.ProductColor;
import com.example.clothingstore.model.ProductDetail;
import com.example.clothingstore.repository.CategoryRepository;
import com.example.clothingstore.repository.ProductRepository;

import jakarta.transaction.Transactional;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    CategoryRepository categoryRepository;

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

    // @Transactional
    public ProductSummaryDTO createProduct(ProductRequestDTO productRequest) {
        Product product = new Product();

        requestToEntity(product, productRequest);
        // Gán danh mục cho sản phẩm
        List<Category> categories = categoryRepository.findAllById(productRequest.getCategoryId());
        categories.forEach((category) -> category.getProducts().add(product));

        productRepository.save(product);

        return new ProductSummaryDTO(product);
    }

    public ProductSummaryDTO deleteProduct(Integer productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Invalid product code"));

        List<Category> categories = categoryRepository.findByProducts_ProductId(productId);

        categories.forEach((category) -> {
            category.getProducts().removeIf(p -> p.getProductId().equals(productId));
        });

        productRepository.deleteById(productId);
        return new ProductSummaryDTO(product);
    }

    @Transactional
    public ProductSummaryDTO updateProduct(Integer productId, ProductRequestDTO productRequest) {
        // Product product = requestToEntity(productRequest);
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Invalid product code"));

        requestToEntity(product, productRequest);
        // Lấy các category mới từ request
        List<Category> newCategories = categoryRepository.findAllById(productRequest.getCategoryId());

        // Clear các category cũ chỉ quan hệ không xóa category
        product.getCategories().forEach(c -> c.getProducts().remove(product));
        product.getCategories().clear();

        // Gán category mới
        product.setCategories(new ArrayList<>(newCategories));
        newCategories.forEach(c -> c.getProducts().add(product)); // đồng bộ hai chiều

        productRepository.save(product);

        return new ProductSummaryDTO(product);
    }

    private void requestToEntity(Product product, ProductRequestDTO productRequest) {

        product.setProductName(productRequest.getProductName());

        product.setUnitPrice(productRequest.getUnitPrice());

        product.setDiscount(productRequest.getDiscount());

        product.setDescription(productRequest.getDescription());

        product.setProductImage(productRequest.getProductImage());

        // product.setCategories(categories);

        List<ProductColor> productColors = new ArrayList<>();
        for (ProductColorRequestDTO productColorRequest : productRequest.getProductColors()) {
            ProductColor productColor = new ProductColor();
            productColor.setColor(productColorRequest.getColor());
            productColor.setProductImage(productColorRequest.getProductImage());

            List<ProductDetail> productDetails = new ArrayList<>();
            for (ProductDetailRequestDTO productDetailRequest : productColorRequest.getProductDetails()) {
                ProductDetail productDetail = new ProductDetail();

                productDetail.setSize(productDetailRequest.getSize());
                productDetail.setQuantity(productDetailRequest.getQuantity());

                // Thiết lập cha cho nó
                productDetail.setProductColor(productColor);

                productDetails.add(productDetail);
            }

            productColor.setProductDetails(productDetails);

            // Thiết lập cha cho nó
            productColor.setProduct(product);
            productColors.add(productColor);
        }

    }
}
