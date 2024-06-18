package com.example.back.repository;

import com.example.back.entity.ImageEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository extends JpaRepository<ImageEntity, String> {
    List<ImageEntity> findByProductId(String productId);

    @Transactional
    void deleteByProductId(String productId);

    @Transactional
    void deleteByUserId(String userId);

    List<ImageEntity> findByProductIdAndImageType(String productId, String type);
}
