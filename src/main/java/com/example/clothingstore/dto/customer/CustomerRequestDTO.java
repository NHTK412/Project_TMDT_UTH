package com.example.clothingstore.dto.customer;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequestDTO {

    private String userName;

    private String password;

    private String email;

    private String gender;

    private String fullName;

    private LocalDateTime date;

    private String phone;

}
