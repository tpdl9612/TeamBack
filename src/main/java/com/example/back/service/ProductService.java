package com.example.back.service;

import com.example.back.dto.response.product.ListProductResponseDto;
import com.example.back.dto.response.product.SaveProductResponseDto;
import com.example.back.dto.response.product.SearchProductResponseDto;
import com.example.back.entity.ProductEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ResponseEntity<? super SearchProductResponseDto> searchProductsFromApi(String keyword);
    ResponseEntity<? super SaveProductResponseDto> saveProducts(ProductEntity product);
    ResponseEntity<? super ListProductResponseDto> getUserCartList(String userId);
}
