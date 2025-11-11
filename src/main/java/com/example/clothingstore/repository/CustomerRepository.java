package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    // @Query("""
    // SELECT c
    // FROM Customer c
    // JOIN FETCH c.account
    // JOIN FETCH c.membershipTier
    // WHERE c.customerId = :customerId
    // """)
    // Optional<Customer> findByIdWithAccountAndMembershipTier(@Param("customerId")
    // Integer customerId);

    // @Query(value = """
    // SELECT c
    // FROM Customer c
    // JOIN FETCH c.account
    // JOIN FETCH c.membershipTier
    // """, countQuery = "SELECT COUNT(c) FROM Customer c")
    // Page<Customer> findAllWithAccountAndMembershipTier(Pageable pageable);

    // Optional<Customer> findByAccount_AccountId(Integer AccountId);

}
