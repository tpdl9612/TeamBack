package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.object.ProductListItem;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.ProductListViewEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class SearchProductResponseDto extends ResponseDto {

    private List<ProductListItem> searchList;

    private SearchProductResponseDto(List<ProductListViewEntity> productListViewEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.searchList = ProductListItem.getList(productListViewEntities);
    }

    public static ResponseEntity<SearchProductResponseDto> success(List<ProductListViewEntity> productListViewEntities){
        SearchProductResponseDto responseBody = new SearchProductResponseDto(productListViewEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
