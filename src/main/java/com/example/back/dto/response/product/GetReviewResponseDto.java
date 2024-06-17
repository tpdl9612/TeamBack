package com.example.back.dto.response.product;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.object.ReviewListItem;
import com.example.back.dto.response.ResponseDto;
import com.example.back.repository.resultSet.GetReviewListResultSet;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetReviewResponseDto extends ResponseDto {

    private List<ReviewListItem> reviewList;

    private GetReviewResponseDto(List<GetReviewListResultSet> resultSets){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.reviewList = ReviewListItem.copyList(resultSets);
    }

    public static ResponseEntity<GetReviewResponseDto> success(List<GetReviewListResultSet> resultSets) {
        GetReviewResponseDto responseBody = new GetReviewResponseDto(resultSets);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistProduct() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_PRODUCT, ResponseMessage.NOT_EXISTED_PRODUCT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
