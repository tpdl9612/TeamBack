package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.ImageEntity;
import com.example.back.repository.resultSet.GetProductResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GetProductResponseDto extends ResponseDto {

    private String productId;
    private String title;
    private String content;
    private String lowPrice;
    private String category1;
    private String category2;
    private String writeDatetime;
    private String userId;
    private List<String> productImageList;
    private List<String> secondaryProductImageList;

    public GetProductResponseDto(GetProductResultSet resultSet, List<ImageEntity> primaryImages, List<ImageEntity> secondaryImages) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.productId = resultSet.getProductId();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.lowPrice = resultSet.getLowPrice();
        this.category1 = resultSet.getCategory1();
        this.category2 = resultSet.getCategory2();
        this.writeDatetime = resultSet.getWriteDatetime();
        this.userId = resultSet.getUserId();

        this.productImageList = new ArrayList<>();
        this.secondaryProductImageList = new ArrayList<>();

        for (ImageEntity imageEntity : primaryImages) {
            this.productImageList.add(imageEntity.getImage());
        }

        for (ImageEntity imageEntity : secondaryImages) {
            this.secondaryProductImageList.add(imageEntity.getImage());
        }
    }

    public static ResponseEntity<GetProductResponseDto> success(GetProductResultSet resultSet, List<ImageEntity> primaryImages, List<ImageEntity> secondaryImages) {
        GetProductResponseDto responseBody = new GetProductResponseDto(resultSet, primaryImages, secondaryImages);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistProduct() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_PRODUCT, ResponseMessage.NOT_EXISTED_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
