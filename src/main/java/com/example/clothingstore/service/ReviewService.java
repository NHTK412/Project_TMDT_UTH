package com.example.clothingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @Autowired
    private ReviewMapper reviewMapper;

    public List<ReviewResponseDTO> getALLReviewByProductId(Integer productId, Pageable pageable) {
        Page<Review> reviews = reviewRepository.findByProduct_ProductId(productId, pageable);

        return reviews
                .map((review) -> reviewMapper.convertModelToReviewResponseDTO(review))
                .toList();
    }

    @Transactional
    public ReviewResponseDTO createReviewByProductId(Integer productId, ReviewRequestDTO reviewRequestDTO) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Invalid product code"));

        Customer customer = customerRepository.findById(1) // CODE CUNG CHO LAM XONG SPRING SECURIY CONTEXT
                .orElseThrow(() -> new NotFoundException("Invalid customer code"));

        Review review = new Review();

        review.setProduct(product);

        review.setCustomer(customer);

        review = reviewMapper.convertReviewRequestDTOtoModel(reviewRequestDTO, review);

        reviewRepository.save(review);

        return reviewMapper.convertModelToReviewResponseDTO(review);

    }

    @Transactional
    public ReviewResponseDTO updateReview(Integer productId, Integer reviewId, ReviewRequestDTO reviewRequestDTO) {

        Review review = reviewRepository.findByReviewIdAndProduct_ProductId(reviewId,
                productId)
                .orElseThrow(() -> new NotFoundException("Invalid review code"));

        // Review review = reviewRepository.findById(reviewId)
        // .orElseThrow(() -> new NotFoundException("Invalid review code"));

        review = reviewMapper.convertReviewRequestDTOtoModel(reviewRequestDTO, review);

        reviewRepository.save(review);

        return reviewMapper.convertModelToReviewResponseDTO(review);

    }

    @Transactional
    public ReviewResponseDTO deleteReview(Integer productId, Integer reviewId) {

        Review review = reviewRepository.findByReviewIdAndProduct_ProductId(reviewId, productId)
                .orElseThrow(() -> new NotFoundException("Invalid review code"));

        ReviewResponseDTO reviewResponseDTO = reviewMapper.convertModelToReviewResponseDTO(review);

        reviewRepository.delete(review);

        return reviewResponseDTO;
    }
}
