package com.example.clothingstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.membershiptier.MembershipTierRequestDTO;
import com.example.clothingstore.dto.membershiptier.MembershipTierResponseDTO;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.mapper.MembershipTierMapper;
import com.example.clothingstore.model.MembershipTier;
import com.example.clothingstore.repository.MembershipTierRepository;

import jakarta.transaction.Transactional;

@Service
public class MembershipTierService {

        @Autowired
        private MembershipTierRepository membershipTierRepository;

        public List<MembershipTierResponseDTO> getAllMembershipTier(Pageable pageable) {
                Page<MembershipTier> membershipTiers = membershipTierRepository.findAll(pageable);

                return membershipTiers
                                .map((membershipTier) -> MembershipTierMapper
                                                .convertModelToMembershipTierResponseDTO(membershipTier))
                                .toList();
        }

        @Transactional
        public MembershipTierResponseDTO createMembershipTier(MembershipTierRequestDTO membershipTierRequestDTO) {
                MembershipTier membershipTier = new MembershipTier();

                membershipTier = MembershipTierMapper.convertMembershipTierRequestDTOToModel(membershipTierRequestDTO,
                                membershipTier);

                membershipTierRepository.save(membershipTier);

                return MembershipTierMapper.convertModelToMembershipTierResponseDTO(membershipTier);
        }

        @Transactional
        public MembershipTierResponseDTO deleteMembershipTier(Integer membershipTieId) {
                MembershipTier membershipTier = membershipTierRepository.findById(membershipTieId)
                                .orElseThrow(() -> new NotFoundException("Invalid membershipTie code"));

                MembershipTierResponseDTO membershipTierResponseDTO = MembershipTierMapper
                                .convertModelToMembershipTierResponseDTO(membershipTier);

                membershipTierRepository.delete(membershipTier);

                return membershipTierResponseDTO;
        }

        @Transactional
        public MembershipTierResponseDTO updateMembershipTier(Integer membershipTieId,
                        MembershipTierRequestDTO membershipTierRequestDTO) {
                MembershipTier membershipTier = membershipTierRepository.findById(membershipTieId)
                                .orElseThrow(() -> new NotFoundException("Invalid membershipTie code"));

                membershipTier = MembershipTierMapper.convertMembershipTierRequestDTOToModel(membershipTierRequestDTO,
                                membershipTier);

                membershipTierRepository.save(membershipTier);

                return MembershipTierMapper.convertModelToMembershipTierResponseDTO(membershipTier);
        }
}
