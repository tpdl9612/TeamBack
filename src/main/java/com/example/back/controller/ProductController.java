package com.example.back.controller;

import com.example.back.dto.response.product.SearchProductResponseDto;
import com.example.back.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<? super SearchProductResponseDto> saveProducts(
            @RequestParam String keyword) {
        ResponseEntity<? super SearchProductResponseDto> response = productService.searchProductsFromApi(keyword);
        return response;
    }
}
