package com.example.back.service;

import com.example.back.dto.request.cart.SaveCartRequestDto;
import com.example.back.dto.response.cart.DeleteCartResponseDto;
import com.example.back.dto.response.cart.ListCartResponseDto;
import com.example.back.dto.response.cart.SaveCartResponseDto;
import com.example.back.dto.response.product.GetSearchProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface CartService {
    ResponseEntity<? super GetSearchProductResponseDto> searchProductsFromApi(String keyword);
    ResponseEntity<? super SaveCartResponseDto> saveProducts(SaveCartRequestDto dto, String userId);
    ResponseEntity<? super ListCartResponseDto> getUserCartList(String userId);
    ResponseEntity<? super DeleteCartResponseDto> deleteProduct(Long productId);
}
