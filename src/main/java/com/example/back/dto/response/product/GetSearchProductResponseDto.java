package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.CartEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;

@Getter
public class GetSearchProductResponseDto extends ResponseDto {
    private List<CartEntity> items;

    public GetSearchProductResponseDto(List<CartEntity> items) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.items = items;
    }

    public static ResponseEntity<GetSearchProductResponseDto> success(List<CartEntity> items){
        GetSearchProductResponseDto responseBody = new GetSearchProductResponseDto(items);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<GetSearchProductResponseDto> fail(){
        GetSearchProductResponseDto responseBody = new GetSearchProductResponseDto(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
