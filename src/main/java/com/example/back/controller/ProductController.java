package com.example.back.controller;

import com.example.back.dto.request.product.SaveProductRequestDto;
import com.example.back.dto.response.product.DeleteProductResponseDto;
import com.example.back.dto.response.product.ListProductResponseDto;
import com.example.back.dto.response.product.SaveProductResponseDto;
import com.example.back.dto.response.product.SearchProductResponseDto;
import com.example.back.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/search")
    public ResponseEntity<? super SearchProductResponseDto> searchProducts(
            @RequestParam String keyword) {
        ResponseEntity<? super SearchProductResponseDto> response = productService.searchProductsFromApi(keyword);
        return response;
    }

    @PostMapping("/save")
    public ResponseEntity<? super SaveProductResponseDto> saveProduct(
            @RequestBody SaveProductRequestDto dto,
            @AuthenticationPrincipal String userId) {
        ResponseEntity<? super SaveProductResponseDto> response = productService.saveProducts(dto, userId);
        return response;
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<? super ListProductResponseDto> getUserProductList(
            @PathVariable("userId") String userId
    ) {
        ResponseEntity<? super ListProductResponseDto> response = productService.getUserCartList(userId);
        return response;
    }

    @DeleteMapping("/delete/{productId}")
    public ResponseEntity<? super DeleteProductResponseDto> deleteProduct(
            @PathVariable("productId") Long productId
    ) {
        ResponseEntity<? super DeleteProductResponseDto> response = productService.deleteProduct(productId);
        return response;
    }
}
