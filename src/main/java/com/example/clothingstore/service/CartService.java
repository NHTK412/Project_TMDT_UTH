package com.example.clothingstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.clothingstore.dto.cart.CartResponseDTO;
import com.example.clothingstore.dto.cartdetail.CartDetailRequestDTO;
import com.example.clothingstore.dto.cartdetail.CartDetailResponseDTO;
import com.example.clothingstore.exception.customer.ConflictException;
import com.example.clothingstore.exception.customer.NotFoundException;
import com.example.clothingstore.mapper.CartDetailMapper;
import com.example.clothingstore.mapper.CartMapper;
import com.example.clothingstore.model.Cart;
import com.example.clothingstore.model.CartDetail;
import com.example.clothingstore.model.ProductDetail;
import com.example.clothingstore.repository.CartDetailRepository;
import com.example.clothingstore.repository.CartRepository;
import com.example.clothingstore.repository.ProductDetailRepository;

import jakarta.transaction.Transactional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartDetailRepository cartDetailRepository;

    @Autowired
    private ProductDetailRepository productDetailRepository;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartDetailMapper cartDetailMapper;

    public CartResponseDTO getCartByCustomer(Integer customerId) {
        Cart cart = cartRepository.findByCustomerIdWithALLFetch(customerId)
                .orElseThrow(() -> new NotFoundException("Invalue Cart By Customer"));

        return cartMapper.convertModelTOCartResponseDTO(cart);
    }

    @Transactional
    public CartDetailResponseDTO addCartItemByCart(Integer customerId, CartDetailRequestDTO cartDetailRequestDTO) {

        Cart cart = cartRepository.findByCustomer_CustomerId(customerId)
                .orElseThrow(() -> new NotFoundException("Invalue Cart By Customer"));

        ProductDetail productDetail = productDetailRepository.findById(cartDetailRequestDTO.getProductDetailId())
                .orElseThrow(() -> new NotFoundException("Invalue Product Detail Code"));

        CartDetail cartDetail = cartDetailRepository.findByCart_CartIdAndProductDetail_DetailId(cart.getCartId(),
                productDetail.getDetailId()).get();
        Integer quantity = (cartDetail == null) ? cartDetailRequestDTO.getQuantity()
                : cartDetail.getQuantity() + cartDetailRequestDTO.getQuantity();
        if (quantity > productDetail.getQuantity()) {
            throw new ConflictException("MAX QUANTITY");
        }
        if (cartDetail == null) {
            cartDetail = new CartDetail();

            cartDetail.setProductDetail(productDetail);

            cartDetail.setIsSelected(true);

            cartDetail.setQuantity(quantity);

            cartDetail.setCart(cart);

            cartDetailRepository.save(cartDetail);

        } else {
            // Integer quantity = cartDetail.getQuantity() +
            // cartDetailRequestDTO.getQuantity();

            // if (quantity == 0) {
            // cartDetailRepository.delete(cartDetail);
            // } else {
            cartDetail.setQuantity(quantity);

            cartDetailRepository.save(cartDetail);

            // }
        }

        // CartDetail

        // cartDetailRepository.save(cartDetail);

        return cartDetailMapper.convertModelToCartDetailResponseDTO(cartDetail);

    }

    @Transactional
    public CartDetailResponseDTO updateCartItem(Integer customerId, Integer cartDetailId, Integer quantity,
            Boolean isSelected) {

        Cart cart = cartRepository.findByCustomer_CustomerId(customerId)
                .orElseThrow(() -> new NotFoundException("Invalue Cart By Customer"));

        CartDetail cartDetail = cartDetailRepository.findByCartDetailIdAndCart_CartId(cartDetailId, cart.getCartId())
                .orElseThrow(() -> new NotFoundException("Invalue"));

        CartDetailResponseDTO cartDetailResponseDTO = null;
        if (quantity != null) {
            if (quantity <= 0) {
                // cartDetailResponseDTO =
                // cartDetailMapper.convertModelToCartDetailResponseDTO(cartDetail);
                cartDetailRepository.delete(cartDetail);
            } else {
                cartDetail.setQuantity(quantity);
            }
        }
        if (isSelected != null) {
            cartDetail.setIsSelected(isSelected);
            // cartDetailResponseDTO =
            // cartDetailMapper.convertModelToCartDetailResponseDTO(cartDetail);

        }
        cartDetailResponseDTO = cartDetailMapper.convertModelToCartDetailResponseDTO(cartDetail);

        return cartDetailResponseDTO;
    }

}
