package com.example.back.repository;

import com.example.back.entity.PaymentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<PaymentEntity, Long> {
    boolean existsByOrderId(String orderId);
}
