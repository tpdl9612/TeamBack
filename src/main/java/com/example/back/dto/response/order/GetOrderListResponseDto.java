package com.example.back.dto.response.order;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.OrderItemEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetOrderListResponseDto extends ResponseDto {

    private List<OrderItemEntity> orderItems;

    private GetOrderListResponseDto(List<OrderItemEntity> orderItems) {
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.orderItems = orderItems;
    }

    public static ResponseEntity<GetOrderListResponseDto> success(List<OrderItemEntity> orderItems) {
        GetOrderListResponseDto responseBody = new GetOrderListResponseDto(orderItems);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> emptyList() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.EMPTY_ORDER, ResponseMessage.EMPTY_ORDER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
