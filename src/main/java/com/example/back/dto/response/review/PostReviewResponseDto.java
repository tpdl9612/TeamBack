package com.example.back.dto.response.review;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PostReviewResponseDto extends ResponseDto {
    private PostReviewResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}
    public static ResponseEntity<PostReviewResponseDto> success(){
        PostReviewResponseDto responseBody = new PostReviewResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
