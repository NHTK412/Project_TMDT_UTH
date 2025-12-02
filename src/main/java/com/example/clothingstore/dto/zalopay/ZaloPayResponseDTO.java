package com.example.clothingstore.dto.zalopay;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ZaloPayResponseDTO {

    @JsonProperty("order_url")
    private String orderUrl;

    @JsonProperty("order_token")
    private String orderToken;

    @JsonProperty("return_message")
    private String returnMessage;

    @JsonProperty("sub_return_message")
    private String subReturnMessage;

    @JsonProperty("sub_return_code")
    private Integer subReturnCode;

    @JsonProperty("cashier_order_url")
    private String cashierOrderUrl;

    @JsonProperty("qr_code")
    private String qrCode;

    @JsonProperty("zp_trans_token")
    private String zpTransToken;

    @JsonProperty("return_code")
    private Integer returnCode;

}
