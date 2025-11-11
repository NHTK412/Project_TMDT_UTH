package com.example.clothingstore.repository;

// import java.lang.foreign.Linker.Option;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

    Page<Review> findByProduct_ProductId(Integer productId, Pageable pageable);

    Optional<Review> findByReviewIdAndProduct_ProductId(Integer reviewId, Integer productId);

}