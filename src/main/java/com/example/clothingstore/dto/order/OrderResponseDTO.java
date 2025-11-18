package com.example.clothingstore.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.clothingstore.dto.orderdetail.OrderDetailResponseDTO;
import com.example.clothingstore.dto.ordergift.OrderGiftResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderResponseDTO {

    private Integer orderId;

    private Double totalAmount;

    private Double discountAmount;

    private Double shippingFee;

    private LocalDateTime deliveryDate;

    private String status;

    private String recipientName;

    private String phoneNumber;

    private String detailedAddress;

    private String ward;

    private String province;

    private String paymentMethod;

    private String vnpayCode;

    private List<OrderDetailResponseDTO> orderDetails;

    private List<OrderGiftResponseDTO> orderGifts;
}
