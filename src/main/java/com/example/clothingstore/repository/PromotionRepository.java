package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.clothingstore.model.Promotion;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

}