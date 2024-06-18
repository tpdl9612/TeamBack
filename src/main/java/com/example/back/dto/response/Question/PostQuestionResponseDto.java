package com.example.back.dto.response.Question;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostQuestionResponseDto extends ResponseDto {
    private PostQuestionResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}
    public static ResponseEntity<PostQuestionResponseDto> success(){
        PostQuestionResponseDto responseBody = new PostQuestionResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
