package com.example.clothingstore.dto.cart;

import java.util.List;

import com.example.clothingstore.dto.cartdetail.CartDetailRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartRequestDTO {

    List<CartDetailRequestDTO> cartDetailRequestDTOs;
}
