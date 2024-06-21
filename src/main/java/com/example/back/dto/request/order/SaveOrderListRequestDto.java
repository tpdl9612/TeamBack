package com.example.back.dto.request.order;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class SaveOrderListRequestDto {
    private String orderId;
    private String userId;
    private String orderDatetime;
    private List<SaveOrderItemRequestDto> items;
}

