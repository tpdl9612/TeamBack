package com.example.back.service.implement;

import com.example.back.dto.request.review.PostReviewRequestDto;

import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.review.GetAllReviewResponseDto;
import com.example.back.dto.response.review.GetReviewResponseDto;
import com.example.back.dto.response.review.PostReviewResponseDto;
import com.example.back.entity.ProductEntity;
import com.example.back.entity.ReviewEntity;
import com.example.back.repository.ProductRepository;
import com.example.back.repository.ReviewRepository;
import com.example.back.repository.UserRepository;
import com.example.back.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImplement implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetReviewResponseDto> getReview(Long reviewId) {
        ReviewEntity reviewEntity = null;
        try{
            reviewEntity = reviewRepository.findByReviewId(reviewId);
            if(reviewEntity == null) return GetReviewResponseDto.notExistReview();
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetReviewResponseDto.success(reviewEntity);
    }

    @Override
    public ResponseEntity<? super PostReviewResponseDto> postReview(PostReviewRequestDto dto, String userId, String productId) {
        try{
            boolean existedUserId = userRepository.existsByUserId(userId);
            if (!existedUserId) return PostReviewResponseDto.notExistUser();

//            ProductEntity product = productRepository.findByProductId(dto.getProductId());
//            if (product == null) return PostReviewResponseDto.notExistProduct();

            ProductEntity product = productRepository.findById(dto.getProductId()).get();
            ReviewEntity reviewEntity = new ReviewEntity(dto, userId, product);
            reviewEntity.setProduct(product);
            reviewEntity.setUserId(userId);
            reviewRepository.save(reviewEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostReviewResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetAllReviewResponseDto> getAllReviews(String productId) {
        List<ReviewEntity> reviews = null;
        try{
            ProductEntity product = productRepository.findByProductId(productId);
            if (product == null) return GetAllReviewResponseDto.notExistProduct();

            reviews = reviewRepository.getReview(productId);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }return GetAllReviewResponseDto.success(reviews);
    }
}

