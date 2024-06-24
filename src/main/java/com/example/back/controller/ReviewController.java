package com.example.back.controller;

import com.example.back.dto.request.product.PostProductRequestDto;
import com.example.back.dto.request.review.PostReviewRequestDto;
import com.example.back.dto.response.product.PostProductResponseDto;
import com.example.back.dto.response.review.GetAllReviewResponseDto;
import com.example.back.dto.response.review.PostReviewResponseDto;
import com.example.back.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product/review")
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("")
    public ResponseEntity<? super PostReviewResponseDto> postReview(
            @RequestBody @Valid PostReviewRequestDto requestBody,
            @AuthenticationPrincipal String userId
    ) {
        ResponseEntity<? super PostReviewResponseDto> response = reviewService.postReview(requestBody, userId);
        return response;
    }

    @GetMapping("/product/{productId}")
    public ResponseEntity<? super GetAllReviewResponseDto> getAllReviews(
            @PathVariable String productId
    ) {
        ResponseEntity<? super GetAllReviewResponseDto> response = reviewService.getAllReviews(productId);
        return response;
    }
}
