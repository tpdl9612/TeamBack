package com.example.back.repository;

import com.example.back.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findByTitleContaining(String keyword);

    List<ProductEntity> findByCategory1Containing(String keyword);

    List<ProductEntity> findByCategory2Containing(String keyword);

    Optional<ProductEntity> findByTitle(String title);
}
