package com.example.clothingstore.dto.zalopay;

import lombok.Data;

/**
 * DTO nhận dữ liệu callback từ ZaloPay khi thanh toán thành công
 * ZaloPay sẽ POST dữ liệu này về callback_url
 */
@Data
public class CallbackData {
    /**
     * data: Chuỗi JSON chứa thông tin giao dịch (đã được mã hóa)
     * Cần parse JSON này để lấy thông tin chi tiết
     */
    private String data;

    /**
     * mac: Chữ ký MAC để verify tính toàn vẹn của data
     * Cần tính lại MAC từ data và so sánh với mac này
     * Nếu khớp -> callback thực sự từ ZaloPay
     */
    private String mac;

    /**
     * type: Loại callback (thường là 1 cho thanh toán)
     */
    private int type;
}
