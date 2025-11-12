package com.example.clothingstore.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.clothingstore.dto.cart.CartResponseDTO;
import com.example.clothingstore.dto.cartdetail.CartDetailRequestDTO;
import com.example.clothingstore.dto.cartdetail.CartDetailResponseDTO;
import com.example.clothingstore.service.CartService;
import com.example.clothingstore.util.ApiResponse;

import jakarta.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping
    public ResponseEntity<ApiResponse<CartResponseDTO>> getCartByCustomer() {
        // return new String();
        Integer customerId = 1;

        CartResponseDTO cartResponseDTO = cartService.getCartByCustomer(customerId);

        return ResponseEntity.ok(new ApiResponse<CartResponseDTO>(true, null, cartResponseDTO));

    }

    @PostMapping("items")
    public ResponseEntity<ApiResponse<CartDetailResponseDTO>> addCartItemByCart(
            @RequestBody CartDetailRequestDTO cartDetailRequestDTO) {

        Integer customerId = 1;

        CartDetailResponseDTO cartDetailResponseDTO = cartService.addCartItemByCart(customerId, cartDetailRequestDTO);

        return ResponseEntity.ok(new ApiResponse<CartDetailResponseDTO>(true, null, cartDetailResponseDTO));

    }

    @PatchMapping("items/{cartDetailId}")
    public ResponseEntity<ApiResponse<CartDetailResponseDTO>> updateCartItem(
            @PathVariable Integer cartDetailId, @RequestParam(required = false) Integer quantity, @RequestParam(required = false) Boolean isSelected) {

        Integer customerId = 1;

        CartDetailResponseDTO cartDetailResponseDTO = cartService.updateCartItem(customerId, cartDetailId, quantity,isSelected);

        return ResponseEntity.ok(new ApiResponse<CartDetailResponseDTO>(true, null, cartDetailResponseDTO));

    }

}

// 1 GET /v1/cart Lấy toàn bộ giỏ hàng hiện tại
// 2 POST /v1/cart/items Thêm 1 sản phẩm vào giỏ
// 3 PATCH /v1/cart/items/{itemId} Cập nhật số lượng / chọn/bỏ chọn
// 4 DELETE /v1/cart/items/{itemId} Xóa 1 dòng
// 5 DELETE /v1/cart/items Xóa nhiều dòng (query param ids)
// 6 POST /v1/cart/clear Làm trống toàn bộ giỏ
// 7 POST /v1/cart/select-all Chọn tất cả item
// 8 POST /v1/cart/unselect-all Bỏ chọn tất cả item
// 9 POST /v1/cart/apply-voucher Áp dụng mã giảm giá
// 10 DELETE /v1/cart/voucher Gỡ mã giảm giá
// 11 GET /v1/cart/totals Lấy tổng tiền, giảm giá, phí ship ước lượng
// 12 POST /v1/cart/sync Đồng bộ giỏ guest → user khi login