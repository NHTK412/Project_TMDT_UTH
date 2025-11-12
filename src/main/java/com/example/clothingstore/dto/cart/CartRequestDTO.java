package com.example.clothingstore.dto.cart;

import com.example.clothingstore.model.Customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequestDTO {

    private Customer customer;

}
