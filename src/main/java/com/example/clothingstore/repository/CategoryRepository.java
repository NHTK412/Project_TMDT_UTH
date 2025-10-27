package com.example.clothingstore.repository;

import com.example.clothingstore.model.Category;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByProducts_ProductId(Integer productId);

}
