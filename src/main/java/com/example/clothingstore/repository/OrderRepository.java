package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}