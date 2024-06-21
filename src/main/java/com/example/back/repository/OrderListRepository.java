package com.example.back.repository;

import com.example.back.entity.OrderListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderListRepository extends JpaRepository<OrderListEntity, String>{
    boolean existsByOrderId(String orderId);
    void deleteByOrderId(String orderId);
    List<OrderListEntity> findByOrderId(String orderId);
}
