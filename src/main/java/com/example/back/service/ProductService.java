package com.example.back.service;

import com.example.back.dto.response.product.SaveProductResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {
    ResponseEntity<? super SaveProductResponseDto> saveProductsFromApi(String keyword);
}
