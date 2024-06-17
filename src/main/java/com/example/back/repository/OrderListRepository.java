package com.example.back.repository;

import com.example.back.entity.OrderListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderListEntity, String>{
    boolean existsByOrderId(String orderId);
}
