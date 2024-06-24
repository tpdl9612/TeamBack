package com.example.back.service;

import com.example.back.dto.request.review.PostReviewRequestDto;
import com.example.back.dto.response.review.GetAllReviewResponseDto;
import com.example.back.dto.response.review.GetReviewResponseDto;
import com.example.back.dto.response.review.PostReviewResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface ReviewService {
    ResponseEntity<? super GetReviewResponseDto> getReview(Long reviewId);
    ResponseEntity<? super PostReviewResponseDto> postReview(PostReviewRequestDto dto, String userId);
    ResponseEntity<? super GetAllReviewResponseDto> getAllReviews(String productId);

//    ResponseEntity<? super PatchReviewResponseDto> patchAnswer(PatchReviewRequestDto dto, Long reviewId);
//    ResponseEntity<? super DeleteReviewResponseDto> deleteReview(Long reviewId);
//    ResponseEntity<? super GetAllReviewResponseDto> getAllReviews();
}
