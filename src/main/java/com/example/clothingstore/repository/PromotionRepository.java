package com.example.clothingstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.clothingstore.model.Promotion;
import com.example.clothingstore.enums.PromotionTypeEnum;

public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    List<Promotion> findByPromotionTypeIn(List<PromotionTypeEnum> promotionTypes);

}