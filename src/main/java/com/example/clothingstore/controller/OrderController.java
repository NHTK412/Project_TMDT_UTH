package com.example.clothingstore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.order.OrderRequestDTO;
import com.example.clothingstore.dto.order.OrderResponseDTO;
import com.example.clothingstore.model.Order;
import com.example.clothingstore.service.OrderService;
import com.example.clothingstore.util.ApiResponse;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public ResponseEntity<ApiResponse<Order>> createOrder(@RequestBody OrderRequestDTO orderRequestDTO) {

        Integer customerId = 1; // Temporary hardcoded customer ID for testing

        Order createdOrder = orderService.createOrder(customerId, orderRequestDTO);

        ApiResponse<Order> response = new ApiResponse<Order>(true, null, createdOrder);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<ApiResponse<OrderResponseDTO>> getOrderById(@PathVariable Integer orderId) {

        OrderResponseDTO orderResponseDTO = orderService.getOrderById(orderId);

        ApiResponse<OrderResponseDTO> response = new ApiResponse<>(true, null, orderResponseDTO);

        return ResponseEntity.ok(response);
    }

}
