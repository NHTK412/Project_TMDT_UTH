package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.customer.CustomerRequestDTO;
import com.example.clothingstore.dto.customer.CustomerResponseDTO;
import com.example.clothingstore.dto.customer.CustomerSummaryDTO;
import com.example.clothingstore.model.Customer;
import com.example.clothingstore.security.CustomerUserDetails;
import com.example.clothingstore.service.CustomerService;
import com.example.clothingstore.util.ApiResponse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PutMapping("/me")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> updateMe(
            @AuthenticationPrincipal CustomerUserDetails userDetails,
            @RequestBody CustomerRequestDTO customerRequestDTO) {

        // BCryptPasswordEncoder bCryptPasswordEncoder = BCryptPasswordEncoder();

        Integer customerId = userDetails.getUserId();

        CustomerResponseDTO customerResponseDTO = customerService.updateCustomer(customerId, customerRequestDTO);

        return ResponseEntity.ok(new ApiResponse<CustomerResponseDTO>(true, null, customerResponseDTO));
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getMe(
            @AuthenticationPrincipal CustomerUserDetails userDetails) {

        Integer customerId = userDetails.getUserId();

        CustomerResponseDTO customerResponseDTO = customerService.getCustomerById(customerId);

        return ResponseEntity.ok(new ApiResponse<CustomerResponseDTO>(true, null, customerResponseDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> getCustomerByID(@PathVariable Integer customerId) {

        CustomerResponseDTO customerResponseDTO = customerService.getCustomerById(customerId);

        return ResponseEntity.ok(new ApiResponse<CustomerResponseDTO>(true, null, customerResponseDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<CustomerSummaryDTO>>> getAllCustomer(@RequestParam Integer page,
            @RequestParam Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);

        List<CustomerSummaryDTO> customerSummaryDTO = customerService.getAllCustomer(pageable);

        return ResponseEntity.ok(new ApiResponse<List<CustomerSummaryDTO>>(true, null, customerSummaryDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> createCustomer(
            @RequestBody CustomerRequestDTO customerRequestDTO) {

        CustomerResponseDTO customerResponseDTO = customerService.createCustomer(customerRequestDTO);

        return ResponseEntity.ok(new ApiResponse<CustomerResponseDTO>(true, null, customerResponseDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{customerId}") // dành cho admin
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> updateCustomer(@PathVariable Integer customerId,
            @RequestBody CustomerRequestDTO customerRequestDTO) {

        // BCryptPasswordEncoder bCryptPasswordEncoder = BCryptPasswordEncoder();

        CustomerResponseDTO customerResponseDTO = customerService.updateCustomer(customerId, customerRequestDTO);

        return ResponseEntity.ok(new ApiResponse<CustomerResponseDTO>(true, null, customerResponseDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{customerId}")
    public ResponseEntity<ApiResponse<CustomerResponseDTO>> deleteCustomer(@PathVariable Integer customerId) {

        CustomerResponseDTO customerResponseDTO = customerService.deleteCustomer(customerId);

        return ResponseEntity.ok(new ApiResponse<CustomerResponseDTO>(true, null, customerResponseDTO));
    }

}
