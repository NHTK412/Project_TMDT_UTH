package com.example.clothingstore.dto.shippingaddress;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingAddressRequestDTO {
    private String recipientName;

    private String phoneNumber;

    private String detailedAdress;

    private String ward;

    private String province;
}
