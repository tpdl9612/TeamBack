package com.example.back.repository;

import com.example.back.entity.OrderItemEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderItemRepository extends JpaRepository<OrderItemEntity, String> {
    List<OrderItemEntity> findByOrderListUserId(String userId);
    @Transactional
    void deleteByOrderListOrderId(String orderId);
}
