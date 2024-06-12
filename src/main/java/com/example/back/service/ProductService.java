package com.example.back.service;

import com.example.back.dto.request.product.SaveProductRequestDto;
import com.example.back.dto.response.product.DeleteProductResponseDto;
import com.example.back.dto.response.product.ListProductResponseDto;
import com.example.back.dto.response.product.SaveProductResponseDto;
import com.example.back.dto.response.product.SearchProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ResponseEntity<? super SearchProductResponseDto> searchProductsFromApi(String keyword);
    ResponseEntity<? super SaveProductResponseDto> saveProducts(SaveProductRequestDto dto, String userId);
    ResponseEntity<? super ListProductResponseDto> getUserCartList(String userId);
    ResponseEntity<? super DeleteProductResponseDto> deleteProduct(Long productId);
}
