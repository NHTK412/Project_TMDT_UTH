package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
