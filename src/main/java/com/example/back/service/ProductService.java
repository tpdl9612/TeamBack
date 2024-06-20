package com.example.back.service;

import com.example.back.dto.request.product.PatchProductRequestDto;
import com.example.back.dto.request.product.PostProductRequestDto;
import com.example.back.dto.request.product.PostReviewRequestDto;
import com.example.back.dto.response.product.*;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    ResponseEntity<? super GetProductResponseDto> getProduct(String productId, String type);
    ResponseEntity<? super GetReviewResponseDto> getReviewList(String productId);
    ResponseEntity<? super SearchProductResponseDto> getSearchProductList(String searchWord);
    ResponseEntity<? super PostProductResponseDto> postProduct(PostProductRequestDto dto, String userId);
    ResponseEntity<? super PatchProductResponseDto> patchProduct(PatchProductRequestDto dto, String productId, String userId);
    ResponseEntity<? super PostReviewResponseDto> postReview(PostReviewRequestDto dto, String productId, String userId);
    ResponseEntity<? super DeleteProductResponseDto> deleteProduct(String productId, String userId);
}
