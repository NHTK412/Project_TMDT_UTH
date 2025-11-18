package com.example.clothingstore.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.clothingstore.dto.orderdetail.OrderDetailRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    // private Double totalAmount;

    private Double shippingFee;

    private LocalDateTime deliveryDate;

    private String status;

    // private String recipientName;

    // private String phoneNumber;

    // private String detailedAddress;

    // private String ward;

    // private String province;

    private Integer addressShippingId;

    private String paymentMethod;

    private String vnpayCode;

    private Integer customerId;

    private List<OrderDetailRequestDTO> orderDetailRequestDTOs;

    private Integer promotionId;
}
