package com.example.clothingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.review.ReviewRequestDTO;
import com.example.clothingstore.dto.review.ReviewResponseDTO;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.mapper.ReviewMapper;
import com.example.clothingstore.model.Customer;
import com.example.clothingstore.model.Product;
import com.example.clothingstore.model.Review;
import com.example.clothingstore.repository.CustomerRepository;
import com.example.clothingstore.repository.ProductRepository;
import com.example.clothingstore.repository.ReviewRepository;

import jakarta.transaction.Transactional;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CustomerRepository customerRepository;

    public List<ReviewResponseDTO> getALLReviewByProductId(Integer productId) {
        List<Review> reviews = reviewRepository.findByProduct_ProductId(productId);

        return reviews.stream()
                .map((review) -> ReviewMapper.convertModelToReviewResponseDTO(review))
                .toList();
    }

    @Transactional
    public ReviewResponseDTO createReviewByProductId(Integer productId, ReviewRequestDTO reviewRequestDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Invalid product code"));

        Customer customer = customerRepository.findById(1) // CODE CUNG CHO LAM XONG SPRING SECURIY CONTEXT
                .orElseThrow(() -> new NotFoundException("Mã khách hàng không hợp lệ"));

        Review review = new Review();

        review.setProduct(product);

        review.setCustomer(customer);

        review = ReviewMapper.convertReviewRequestDTOtoModel(reviewRequestDTO, review);

        reviewRepository.save(review);

        return ReviewMapper.convertModelToReviewResponseDTO(review);

    }

    @Transactional
    public ReviewResponseDTO updateReview(Integer productId, Integer reviewId, ReviewRequestDTO reviewRequestDTO) {
        // Product product = productRepository.findById(productId)
        // .orElseThrow(() -> new NotFoundException("Invalid product code"));

        // Customer customer = customerRepository.findById(1) // CODE CUNG CHO LAM XONG
        // SPRING SECURIY CONTEXT
        // .orElseThrow(() -> new NotFoundException("Mã khách hàng không hợp lệ"));

        Review review = reviewRepository.findByReviewIdAndProduct_ProductId(reviewId, productId)
                .orElseThrow(() -> new NotFoundException("Invalid review code"));

        review = ReviewMapper.convertReviewRequestDTOtoModel(reviewRequestDTO, review);

        reviewRepository.save(review);

        return ReviewMapper.convertModelToReviewResponseDTO(review);

    }
}
