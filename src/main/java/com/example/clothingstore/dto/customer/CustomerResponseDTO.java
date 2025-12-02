package com.example.clothingstore.dto.customer;

import java.time.LocalDateTime;

import com.example.clothingstore.enums.AccountStatusEnum;
import com.example.clothingstore.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerResponseDTO {

    private Integer customerId;

    private String userName;

    // private String password;

    private String email;

    private GenderEnum gender;

    private String fullName;

    private LocalDateTime date;

    private String phone;

    private String membership;

    private String colorMembership;

    private AccountStatusEnum status;

    private LocalDateTime lastLogin;

    private String image;

    // private List<Review> reviews;

    // private List<Order> orders;

    // private MembershipTier membershipTier;

    // private List<ShippingAddress> shippingAddresses;
}
