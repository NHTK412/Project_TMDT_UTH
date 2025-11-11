package com.example.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.membershiptier.MembershipTierRequestDTO;
import com.example.clothingstore.dto.membershiptier.MembershipTierResponseDTO;
import com.example.clothingstore.service.MembershipTierService;
import com.example.clothingstore.util.ApiResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/membership-tier")
public class MembershipTierController {

        @Autowired
        private MembershipTierService membershipTierService;

        @GetMapping
        public ResponseEntity<ApiResponse<List<MembershipTierResponseDTO>>> getAllMembershipTier(
                        @RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer size) {

                Pageable pageable = PageRequest.of(page - 1, size);

                List<MembershipTierResponseDTO> membershipTierResponseDTOs = membershipTierService
                                .getAllMembershipTier(pageable);

                return ResponseEntity
                                .ok(new ApiResponse<List<MembershipTierResponseDTO>>(true, null,
                                                membershipTierResponseDTOs));
        }

        @PostMapping
        public ResponseEntity<ApiResponse<MembershipTierResponseDTO>> createMembershipTier(
                        @RequestBody MembershipTierRequestDTO membershipTierRequestDTO) {

                MembershipTierResponseDTO membershipTierResponseDTO = membershipTierService
                                .createMembershipTier(membershipTierRequestDTO);

                return ResponseEntity
                                .ok(new ApiResponse<MembershipTierResponseDTO>(true, null, membershipTierResponseDTO));
        }

        @DeleteMapping("/{membershipTieId}")
        public ResponseEntity<ApiResponse<MembershipTierResponseDTO>> deleteMembershipTier(
                        @PathVariable Integer membershipTieId) {

                MembershipTierResponseDTO membershipTierResponseDTO = membershipTierService
                                .deleteMembershipTier(membershipTieId);

                return ResponseEntity
                                .ok(new ApiResponse<MembershipTierResponseDTO>(true, null, membershipTierResponseDTO));
        }

        @PutMapping("/{membershipTieId}")
        public ResponseEntity<ApiResponse<MembershipTierResponseDTO>> updateMembershipTier(
                        @PathVariable Integer membershipTieId,
                        @RequestBody MembershipTierRequestDTO membershipTierRequestDTO) {

                MembershipTierResponseDTO membershipTierResponseDTO = membershipTierService
                                .updateMembershipTier(membershipTieId, membershipTierRequestDTO);

                return ResponseEntity
                                .ok(new ApiResponse<MembershipTierResponseDTO>(true, null, membershipTierResponseDTO));
        }

}
