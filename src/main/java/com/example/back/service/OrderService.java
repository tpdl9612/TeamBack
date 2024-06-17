package com.example.back.service;

import com.example.back.dto.request.order.SaveOrderListRequestDto;
import com.example.back.dto.response.order.GetOrderListResponseDto;
import com.example.back.dto.response.order.SaveOrderListResponseDto;
import org.springframework.http.ResponseEntity;

public interface OrderService {
    ResponseEntity<? super SaveOrderListResponseDto> saveOrderInfo(SaveOrderListRequestDto dto);
    ResponseEntity<? super GetOrderListResponseDto> getOrderListByUserId(String userId);
}
