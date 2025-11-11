package com.example.clothingstore.dto.customer;


import com.example.clothingstore.enums.AccountStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerSummaryDTO {

    private Integer customerId;

    private String userName;

    // private String password;

    private String email;

    // private String gender;

    // private String fullName;

    // private LocalDateTime date;

    private String phone;

    private String membership;

    private String colorMembership;

    private AccountStatusEnum status;

    // private LocalDateTime lastLogin;

}
