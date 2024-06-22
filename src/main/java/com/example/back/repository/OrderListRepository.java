package com.example.back.repository;

import com.example.back.entity.OrderListEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface OrderListRepository extends JpaRepository<OrderListEntity, String>{
    boolean existsByOrderId(String orderId);
    @Transactional
    void deleteByOrderId(String orderId);
    List<OrderListEntity> findByOrderId(String orderId);
}
