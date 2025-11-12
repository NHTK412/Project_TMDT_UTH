package com.example.clothingstore.dto.cart;

import java.util.ArrayList;
import java.util.List;

import com.example.clothingstore.dto.cartdetail.CartDetailResponseDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartResponseDTO {

    private Integer cartId;

    private List<CartDetailResponseDTO> cartDetailResponseDTOs = new ArrayList<>();

}
