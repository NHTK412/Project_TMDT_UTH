package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clothingstore.model.ProductColor;

public interface ProductColorRepository extends JpaRepository<ProductColor, Integer> {

}
