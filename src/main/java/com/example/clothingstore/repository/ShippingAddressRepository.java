package com.example.clothingstore.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.ShippingAddress;

@Repository
public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Integer> {

    Optional<ShippingAddress> findByAddressIdAndCustomer_CustomerId(Integer addressId, Integer customerId);

    Page<ShippingAddress> findByCustomer_CustomerId(Integer customerId, Pageable pageable);
}
