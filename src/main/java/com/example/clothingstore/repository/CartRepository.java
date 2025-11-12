package com.example.clothingstore.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("""
            SELECT c
            FROM Cart c
            JOIN FETCH c.cartDetails cd
            JOIN FETCH cd.productDetail pd
            JOIN FETCH pd.productColor pc
            JOIN FETCH pc.product p
            JOIN FETCH c.customer cu
            WHERE cu.customerId = :customerId
                """)
    Optional<Cart> findByCustomerIdWithALLFetch(Integer customerId);

    Optional<Cart> findByCustomer_CustomerId(Integer customerId);
}