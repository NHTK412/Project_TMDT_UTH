package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.ProductDetail;

@Repository
public interface ProductDetailRepository extends JpaRepository<ProductDetail, Integer> {

}