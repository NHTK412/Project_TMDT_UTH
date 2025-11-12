package com.example.clothingstore.mapper;

import org.springframework.stereotype.Component;

import com.example.clothingstore.dto.review.ReviewRequestDTO;
import com.example.clothingstore.dto.review.ReviewResponseDTO;
import com.example.clothingstore.model.Review;

@Component
public class ReviewMapper {

    public ReviewResponseDTO convertModelToReviewResponseDTO(Review review) {
        ReviewResponseDTO reviewResponseDTO = new ReviewResponseDTO();

        reviewResponseDTO.setRating(review.getRating());

        reviewResponseDTO.setReviewContent(review.getReviewContent());

        reviewResponseDTO.setReviewId(review.getReviewId());

        reviewResponseDTO.setUserNameCustomer(review.getCustomer().getUserName());

        return reviewResponseDTO;
    }

    public Review convertReviewRequestDTOtoModel(ReviewRequestDTO reviewRequestDTO, Review review) {

        review.setRating(reviewRequestDTO.getRating());

        review.setReviewContent(reviewRequestDTO.getReviewContent());

        return review;
    }
}
