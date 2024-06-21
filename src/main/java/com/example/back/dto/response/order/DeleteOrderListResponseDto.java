package com.example.back.dto.response.order;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class DeleteOrderListResponseDto extends ResponseDto {

    private DeleteOrderListResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<DeleteOrderListResponseDto> success(){
        DeleteOrderListResponseDto result = new DeleteOrderListResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    public static ResponseEntity<ResponseDto> notExistedOrder(){
        ResponseDto result = new ResponseDto(ResponseCode.NOT_EXISTED_ORDER, ResponseMessage.NOT_EXISTED_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
    }
}
