package com.example.clothingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.clothingstore.model.MembershipTier;

@Repository
public interface MembershipTierRepository extends JpaRepository<MembershipTier, Integer> {

}
