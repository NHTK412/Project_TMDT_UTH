package com.example.clothingstore.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.clothingstore.dto.cart.CartResponseDTO;
import com.example.clothingstore.dto.cartdetail.CartDetailResponseDTO;
import com.example.clothingstore.model.Cart;

@Component
public class CartMapper {

    @Autowired
    private CartDetailMapper cartDetailMapper;

    public CartResponseDTO convertModelTOCartResponseDTO(Cart cart) {
        CartResponseDTO cartResponseDTO = new CartResponseDTO();

        cartResponseDTO.setCartId(cart.getCartId());

        List<CartDetailResponseDTO> cartDetailResponseDTOs = cart.getCartDetails()
                .stream()
                .map((cartDetailResponseDTO) -> cartDetailMapper
                        .convertModelToCartDetailResponseDTO(cartDetailResponseDTO))
                .toList();

        cartResponseDTO.setCartDetailResponseDTOs(cartDetailResponseDTOs);

        return cartResponseDTO;
    }

}
