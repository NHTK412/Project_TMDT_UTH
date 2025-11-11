package com.example.clothingstore.repository;

import com.example.clothingstore.enums.CategoryStatusEnum;
import com.example.clothingstore.model.Category;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByProducts_ProductId(Integer productId);

    // @Query("""
    // SELECT c
    // FROM category c
    // WHERE c.status = :status
    // """)
    Page<Category> findByStatus(@Param("status") CategoryStatusEnum status, Pageable pageable);

}
