package com.example.back.controller;

import com.example.back.dto.request.cart.SaveCartRequestDto;
import com.example.back.dto.response.cart.DeleteCartResponseDto;
import com.example.back.dto.response.cart.ListCartResponseDto;
import com.example.back.dto.response.cart.SaveCartResponseDto;
import com.example.back.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/cart")
public class CartController {

    private final CartService cartService;

    @PostMapping("/save")
    public ResponseEntity<? super SaveCartResponseDto> saveProduct(
            @RequestBody SaveCartRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<? super SaveCartResponseDto> response = cartService.saveProducts(dto, userId);
        return response;
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<? super ListCartResponseDto> getUserProductList(
            @PathVariable("userId") String userId
    ) {
        ResponseEntity<? super ListCartResponseDto> response = cartService.getUserCartList(userId);
        return response;
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<? super DeleteCartResponseDto> deleteProduct(
            @PathVariable("productId") Long productId
    ) {
        ResponseEntity<? super DeleteCartResponseDto> response = cartService.deleteProduct(productId);
        return response;
    }
}
