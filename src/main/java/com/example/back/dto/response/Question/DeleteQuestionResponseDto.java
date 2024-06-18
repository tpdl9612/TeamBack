package com.example.back.dto.response.Question;


import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class DeleteQuestionResponseDto extends ResponseDto {
    private DeleteQuestionResponseDto(){super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);}
    public static ResponseEntity<DeleteQuestionResponseDto> success(){
        DeleteQuestionResponseDto result = new DeleteQuestionResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
    public static ResponseEntity<ResponseDto> notExistedQuestion(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_QUESTION,ResponseMessage.NOT_EXISTED_QUESTION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
