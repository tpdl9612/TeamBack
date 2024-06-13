package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class DeleteProductResponseDto extends ResponseDto {

        private DeleteProductResponseDto(){
            super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        }

        public static ResponseEntity<DeleteProductResponseDto> success(){
            DeleteProductResponseDto responseBody = new DeleteProductResponseDto();
            return ResponseEntity.status(HttpStatus.OK).body(responseBody);
        }

        public static ResponseEntity<ResponseDto> notExistedProduct(){
            ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_PRODUCT, ResponseMessage.NOT_EXISTED_PRODUCT);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
        }
}
