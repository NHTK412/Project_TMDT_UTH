package com.example.clothingstore.dto.customer;

import java.time.LocalDateTime;

import com.example.clothingstore.enums.GenderEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CustomerRequestDTO {

    private String userName;

    // private String password;

    private String email;

    private GenderEnum gender;

    private String fullName;

    private LocalDateTime date;

    private String phone;

    private String image;

}
