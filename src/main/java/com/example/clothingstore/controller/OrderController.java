package com.example.clothingstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.order.OrderRequestDTO;
import com.example.clothingstore.dto.order.OrderResponseDTO;
import com.example.clothingstore.dto.order.OrderSummaryDTO;
import com.example.clothingstore.enums.OrderStatusEnum;
import com.example.clothingstore.model.Order;
import com.example.clothingstore.service.OrderService;
import com.example.clothingstore.util.ApiResponse;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PreAuthorize("hasRole('CUSTOMER')")
    @PostMapping
    public ResponseEntity<ApiResponse<OrderResponseDTO>> createOrder(@AuthenticationPrincipal UserDetails userDetails,
            @RequestBody OrderRequestDTO orderRequestDTO) {

        // Integer customerId = 1; // Temporary hardcoded customer ID for testing

        String userName = userDetails.getUsername();

        OrderResponseDTO createdOrder = orderService.createOrder(userName, orderRequestDTO);

        ApiResponse<OrderResponseDTO> response = new ApiResponse<OrderResponseDTO>(true, null, createdOrder);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasAnyRole('CUSTOMER', 'ADMIN')")
    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponseDTO>> getOrderById(@PathVariable Integer orderId) {

        OrderResponseDTO orderResponseDTO = orderService.getOrderById(orderId);

        ApiResponse<OrderResponseDTO> response = new ApiResponse<>(true, null, orderResponseDTO);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @GetMapping("/me")
    public ResponseEntity<ApiResponse<List<OrderSummaryDTO>>> getAllOrderByCustomer(@RequestParam Integer page,
            @RequestParam Integer size) {
        // return new String();

        Pageable pageable = PageRequest.of(page - 1, size);

        Integer customerId = 1; // Temporary hardcoded customer ID for testing

        List<OrderSummaryDTO> orderSummaries = orderService.getAllOrdersByCustomer(customerId, pageable); // Temporary
                                                                                                          // hardcoded
                                                                                                          // customer ID
                                                                                                          // for testing

        ApiResponse<List<OrderSummaryDTO>> response = new ApiResponse<>(true, null, orderSummaries);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<ApiResponse<List<OrderSummaryDTO>>> getAllOrder(@RequestParam Integer page,
            @RequestParam Integer size) {
        // return new String();

        Pageable pageable = PageRequest.of(page - 1, size);

        List<OrderSummaryDTO> orderSummaries = orderService.getAllOrders(pageable); // Temporary
                                                                                    // hardcoded
                                                                                    // customer ID
                                                                                    // for testing

        ApiResponse<List<OrderSummaryDTO>> response = new ApiResponse<>(true, null, orderSummaries);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponseDTO>> updateStatus(@PathVariable Integer orderId,
            @RequestParam OrderStatusEnum status) {

        OrderResponseDTO updatedOrder = orderService.updateStatus(orderId, status);

        ApiResponse<OrderResponseDTO> response = new ApiResponse<>(true, null, updatedOrder);

        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('CUSTOMER')")
    @PatchMapping("/{orderId}/canceled")
    public ResponseEntity<ApiResponse<OrderResponseDTO>> updateStatus(@PathVariable Integer orderId) {

        OrderResponseDTO updatedOrder = orderService.updateStatus(orderId, OrderStatusEnum.CANCELED);

        ApiResponse<OrderResponseDTO> response = new ApiResponse<>(true, null, updatedOrder);

        return ResponseEntity.ok(response);
    }

}
