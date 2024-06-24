package com.example.back.dto.response.review;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.ReviewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetReviewResponseDto extends ResponseDto {
    private Long reviewId;
    private String content;
    private String userId;

    private String productId;
    private String writeDatetime;
    //    private Long questionId;
    public GetReviewResponseDto(ReviewEntity reviewEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.reviewId = reviewEntity.getReviewId();
        this.content = reviewEntity.getContent();
        this.userId = reviewEntity.getUserId();
        this.writeDatetime = reviewEntity.getWriteDatetime();
    }
    public static ResponseEntity<GetReviewResponseDto> success(ReviewEntity reviewEntity){
        GetReviewResponseDto responseBody = new GetReviewResponseDto(reviewEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    public static ResponseEntity<ResponseDto> notExistReview(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_ANSWER,ResponseMessage.NOT_EXISTED_REVIEW);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }



}
