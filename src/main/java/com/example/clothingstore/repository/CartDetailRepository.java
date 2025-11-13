package com.example.clothingstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.CartItem;

@Repository
public interface CartDetailRepository extends JpaRepository<CartItem, Integer> {

    Optional<CartItem> findByCart_CartIdAndProductDetail_DetailId(Integer cartId, Integer productDetailId);

    Optional<CartItem> findByCartItemIdAndCart_CartId(Integer cartItemId, Integer cartId);

}