package com.example.back.repository;

import com.example.back.entity.OrderItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemRepository extends JpaRepository<OrderItemEntity, String> {
    List<OrderItemEntity> findByOrderListUserId(String userId);
}
