package com.example.back.dto.response.cart;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class SaveCartResponseDto extends ResponseDto {

    public SaveCartResponseDto() {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<SaveCartResponseDto> success(){
        SaveCartResponseDto responseBody = new SaveCartResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicatedProduct(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_PRODUCT, ResponseMessage.DUPLICATED_PRODUCT);
        return ResponseEntity.status(HttpStatus.CONFLICT).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }
}
