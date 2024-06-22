package com.example.back.repository;

import com.example.back.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<CartEntity, Long> {
//    CartEntity findByProductId(Long productId);
    Optional<CartEntity> findByProductId(Long productId);
    List<CartEntity> findByUserId(String userId);
}

