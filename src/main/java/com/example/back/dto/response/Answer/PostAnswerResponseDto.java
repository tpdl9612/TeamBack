package com.example.back.dto.response.Answer;


import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostAnswerResponseDto extends ResponseDto {
    private PostAnswerResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}
    public static ResponseEntity<PostAnswerResponseDto> success(){
        PostAnswerResponseDto responseBody = new PostAnswerResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
