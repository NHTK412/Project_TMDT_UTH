package com.example.clothingstore.dto.zalopay;

import lombok.Data;

/**
 * DTO (Data Transfer Object) chứa thông tin yêu cầu tạo đơn hàng ZaloPay
 * Class này được sử dụng để nhận dữ liệu từ client khi gọi API tạo đơn hàng
 */
@Data // Lombok tự động generate getter, setter, toString, equals, hashCode
public class CreateOrderRequest {
    /**
     * Số tiền thanh toán (đơn vị: VNĐ)
     * Ví dụ: 50000 tương đương 50,000 VNĐ
     */
    // private long amount;

    // /**
    // * Mô tả đơn hàng
    // * Ví dụ: "Thanh toán đơn hàng #123" hoặc "Mua áo thun size M"
    // */
    // private String description;

    // /**
    // * Định danh người dùng trong hệ thống
    // * Thường là user_id hoặc username để ZaloPay biết ai đang thanh toán
    // */
    // private String appUser;

    private Integer orderId;

    private String description;


}
