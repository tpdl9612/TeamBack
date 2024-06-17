package com.example.back.dto.response.cart;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.CartEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class ListCartResponseDto extends ResponseDto {

    private List<CartEntity> items;

    public ListCartResponseDto(List<CartEntity> items) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.items = items;
    }

    public static ResponseEntity<ListCartResponseDto> success(List<CartEntity> products){
        ListCartResponseDto responseBody = new ListCartResponseDto(products);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ListCartResponseDto> fail(){
        ListCartResponseDto responseBody = new ListCartResponseDto(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
