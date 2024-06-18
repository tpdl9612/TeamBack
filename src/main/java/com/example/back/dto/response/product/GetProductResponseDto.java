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
    private String link;
    private List<String> productImageList;
    private String lowPrice;
    private String category1;
    private String category2;
    private String writeDatetime;
    private String writerId;
    private String writerNickname;

    public GetProductResponseDto(GetProductResultSet resultSet, List<ImageEntity> imageEntities){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);

        List<String> productImageList = new ArrayList<>();
        for(ImageEntity imageEntity: imageEntities){
            String boardImage =  imageEntity.getImage();
            productImageList.add(boardImage);
        }
        this.productId = resultSet.getProductId();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.link = resultSet.getLink();
        this.productImageList = productImageList;
        this.writeDatetime = resultSet.getWriteDatetime();
        this.writerId = resultSet.getUserId();
        this.lowPrice = resultSet.getLowPrice();
        this.category1 = resultSet.getCategory1();
        this.category2 = resultSet.getCategory2();
    }

    public static ResponseEntity<GetProductResponseDto> success(GetProductResultSet resultSet, List<ImageEntity> imageEntities){
        GetProductResponseDto responseBody = new GetProductResponseDto(resultSet, imageEntities);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistProduct(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_PRODUCT, ResponseMessage.NOT_EXISTED_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
