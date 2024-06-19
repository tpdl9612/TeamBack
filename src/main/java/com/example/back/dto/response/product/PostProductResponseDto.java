package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PostProductResponseDto extends ResponseDto {

    private PostProductResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PostProductResponseDto> success(){
        PostProductResponseDto responseBody = new PostProductResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicateProductId(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_PRODUCT_ID, ResponseMessage.DUPLICATED_PRODUCT_ID);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
