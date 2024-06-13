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
public class SearchProductResponseDto extends ResponseDto {
    private List<ProductEntity> items;

    public SearchProductResponseDto(List<ProductEntity> items) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.items = items;
    }

    public static ResponseEntity<SearchProductResponseDto> success(List<ProductEntity> items){
        SearchProductResponseDto responseBody = new SearchProductResponseDto(items);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<SearchProductResponseDto> fail(){
        SearchProductResponseDto responseBody = new SearchProductResponseDto(null);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(responseBody);
    }
}
