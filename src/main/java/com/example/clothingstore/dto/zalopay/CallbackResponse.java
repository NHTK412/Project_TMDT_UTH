package com.example.clothingstore.dto.zalopay;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * DTO trả về cho ZaloPay sau khi xử lý callback
 * ZaloPay yêu cầu phải trả về JSON với format này
 */
@Data
@AllArgsConstructor
public class CallbackResponse {
    /**
     * return_code: Mã trả về
     * - 1: Xử lý thành công
     * - -1: Xử lý thất bại (ZaloPay sẽ retry callback)
     */
    private int return_code;

    /**
     * return_message: Thông báo kết quả
     */
    private String return_message;
}
