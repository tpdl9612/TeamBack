package com.example.back.dto.response.review;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.Answer.GetAllAnswerResponseDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.AnswerEntity;
import com.example.back.entity.ReviewEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GetAllReviewResponseDto extends ResponseDto {
    private List<ReviewEntity> reviews;

    public GetAllReviewResponseDto(List<ReviewEntity> reviews){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.reviews = reviews;
    }
    public static ResponseEntity<GetAllReviewResponseDto> success(List<ReviewEntity> reviews){
        GetAllReviewResponseDto responseBody = new GetAllReviewResponseDto(reviews);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistProduct(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_PRODUCT,ResponseMessage.NOT_EXISTED_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
