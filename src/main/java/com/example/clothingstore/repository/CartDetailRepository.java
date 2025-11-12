package com.example.clothingstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.CartDetail;

@Repository
public interface CartDetailRepository extends JpaRepository<CartDetail, Integer> {

    Optional<CartDetail> findByCart_CartIdAndProductDetail_DetailId(Integer cartId, Integer productDetailId);

    Optional<CartDetail> findByCartDetailIdAndCart_CartId(Integer cartDetailId, Integer cartId);

}