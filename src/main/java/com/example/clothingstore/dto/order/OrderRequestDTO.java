package com.example.clothingstore.dto.order;

import java.time.LocalDateTime;
import java.util.List;

import com.example.clothingstore.dto.orderdetail.OrderDetailRequestDTO;
import com.example.clothingstore.enums.PaymentMethodEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequestDTO {

    // private Double shippingFee;

    // private LocalDateTime deliveryDate; // Ngày giao hàng dự kiến

    private Integer addressShippingId;

    private PaymentMethodEnum paymentMethod;

    // private String vnpayCode;

    // private Integer customerId;

    private List<OrderDetailRequestDTO> orderDetailRequestDTOs;

    // private Integer promotionDiscountId; // Mã khuyến mãi giảm giá

    // danh sách mã quà tặng
    // private List<Integer> promotionGiftIds;
}
