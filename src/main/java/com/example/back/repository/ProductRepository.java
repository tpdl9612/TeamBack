package com.example.back.repository;

import com.example.back.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByProductId(Long productId);
    List<ProductEntity> findByUserId(String userId);
}

