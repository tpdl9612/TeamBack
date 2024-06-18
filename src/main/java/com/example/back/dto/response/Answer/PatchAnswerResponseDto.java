package com.example.back.dto.response.Answer;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PatchAnswerResponseDto extends ResponseDto {
    private PatchAnswerResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}
    public static ResponseEntity<PatchAnswerResponseDto> success(){
        PatchAnswerResponseDto responseBody = new PatchAnswerResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    public static ResponseEntity<ResponseDto> notExistAnswer(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_ANSWER,ResponseMessage.NOT_EXISTED_ANSWER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
