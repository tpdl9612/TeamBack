package com.example.back.service.implement;

import com.example.back.dto.request.order.SaveOrderListRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.order.GetOrderListResponseDto;
import com.example.back.dto.response.order.SaveOrderListResponseDto;
import com.example.back.entity.OrderItemEntity;
import com.example.back.entity.OrderListEntity;
import com.example.back.repository.OrderItemRepository;
import com.example.back.repository.OrderListRepository;
import com.example.back.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImplement implements OrderService {

    private final OrderListRepository orderListRepository;
    private final OrderItemRepository orderItemRepository;

    @Override
    public ResponseEntity<? super SaveOrderListResponseDto> saveOrderInfo(SaveOrderListRequestDto dto) {
        try {
            OrderListEntity orderListEntity = new OrderListEntity(dto, dto.getUserId());
            if (orderListRepository.existsByOrderId(orderListEntity.getOrderId())) {
                return SaveOrderListResponseDto.duplicatedOrder();
            }
            orderListRepository.save(orderListEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SaveOrderListResponseDto.success();
    }

    @Override
    public ResponseEntity<? super GetOrderListResponseDto> getOrderListByUserId(String userId) {
        List<OrderItemEntity> orderItems = orderItemRepository.findByOrderListUserId(userId);
        try {
            if (orderItems.isEmpty()) {
                return GetOrderListResponseDto.emptyList();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return GetOrderListResponseDto.success(orderItems);
    }
}
