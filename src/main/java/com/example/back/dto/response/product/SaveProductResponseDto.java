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
public class SaveProductResponseDto extends ResponseDto {
    private List<ProductEntity> items;

    public SaveProductResponseDto(List<ProductEntity> items) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.items = items;
    }

    public static ResponseEntity<SaveProductResponseDto> success(List<ProductEntity> items){
        SaveProductResponseDto responseBody = new SaveProductResponseDto(items);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> duplicatedTitle(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.DUPLICATED_TITLE, ResponseMessage.DUPLICATED_TITLE);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }

    public static ResponseEntity<SaveProductResponseDto> fail(){
        SaveProductResponseDto responseBody = new SaveProductResponseDto(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
