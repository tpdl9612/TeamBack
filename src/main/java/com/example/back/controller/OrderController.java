package com.example.back.controller;

import com.example.back.dto.request.order.SaveOrderListRequestDto;
import com.example.back.dto.response.order.GetOrderListResponseDto;
import com.example.back.dto.response.order.SaveOrderListResponseDto;
import com.example.back.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
@CrossOrigin(origins = "http://3.35.30.191:3000")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping("/saveOrderInfo")
    public ResponseEntity<? super SaveOrderListResponseDto> saveOrderInfo(@RequestBody SaveOrderListRequestDto requestBody) {
        ResponseEntity<? super SaveOrderListResponseDto> response = orderService.saveOrderInfo(requestBody);
        return response;
    }

    @GetMapping("/list/{userId}")
    public ResponseEntity<? super GetOrderListResponseDto> getOrderList(@PathVariable String userId) {
        ResponseEntity<? super GetOrderListResponseDto> response = orderService.getOrderListByUserId(userId);
        return response;
    }
}
