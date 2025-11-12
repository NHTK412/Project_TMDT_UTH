package com.example.clothingstore.mapper;

import org.springframework.stereotype.Component;

import com.example.clothingstore.dto.cartdetail.CartDetailResponseDTO;
import com.example.clothingstore.model.CartDetail;

@Component
public class CartDetailMapper {

    public CartDetailResponseDTO convertModelToCartDetailResponseDTO(CartDetail cartDetail) {
        CartDetailResponseDTO cartDetailResponseDTO = new CartDetailResponseDTO();

        cartDetailResponseDTO.setCartDetailId(cartDetail.getCartDetailId());

        cartDetailResponseDTO.setProductId(cartDetail.getProductDetail().getProductColor().getProduct().getProductId());

        cartDetailResponseDTO.setProductDetailId(cartDetail.getProductDetail().getDetailId());

        cartDetailResponseDTO.setProductColorId(cartDetail.getProductDetail().getProductColor().getColorId());

        cartDetailResponseDTO
                .setProductName(cartDetail.getProductDetail().getProductColor().getProduct().getProductName());

        cartDetailResponseDTO.setColor(cartDetail.getProductDetail().getProductColor().getColor());

        cartDetailResponseDTO.setProductDetailsize(cartDetail.getProductDetail().getSize());

        cartDetailResponseDTO.setProductImage(cartDetail.getProductDetail().getProductColor().getProductImage());

        cartDetailResponseDTO.setIsSelected(cartDetail.getIsSelected());

        cartDetailResponseDTO.setQuantity(cartDetail.getQuantity());

        cartDetailResponseDTO.setUnitPrice(cartDetail.getProductDetail().getProductColor().getProduct().getUnitPrice());

        cartDetailResponseDTO.setProductDetailQuantity(cartDetail.getProductDetail().getQuantity());

        return cartDetailResponseDTO;
    }

}
