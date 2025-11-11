package com.example.clothingstore.dto.account;

import java.time.LocalDateTime;

import com.example.clothingstore.enums.AccountStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountSummaryDTO {

    private Integer accountId;

    private AccountStatusEnum status;

    private String userName;

    private String password;

    private String role;

    private LocalDateTime lastLogin;

    // private Customer customer;

    // private Admin admin;

}
