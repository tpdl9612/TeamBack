package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.ProductEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class ListProductResponseDto extends ResponseDto {

    private List<ProductEntity> items;

    public ListProductResponseDto(List<ProductEntity> items) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.items = items;
    }

    public static ResponseEntity<ListProductResponseDto> success(List<ProductEntity> products){
        ListProductResponseDto responseBody = new ListProductResponseDto(products);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistUser() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_USER, ResponseMessage.NOT_EXISTED_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }

    public static ResponseEntity<ListProductResponseDto> fail(){
        ListProductResponseDto responseBody = new ListProductResponseDto(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
