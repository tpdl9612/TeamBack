package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class SaveProductResponseDto extends ResponseDto {

    public SaveProductResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<SaveProductResponseDto> success(){
        SaveProductResponseDto responseBody = new SaveProductResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicatedTitle(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_TITLE, ResponseMessage.DUPLICATED_TITLE);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseBody);
    }

    public static ResponseEntity<SaveProductResponseDto> fail(){
        SaveProductResponseDto responseBody = new SaveProductResponseDto();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
