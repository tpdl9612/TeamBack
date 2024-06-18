package com.example.back.repository;

import com.example.back.entity.ProductListViewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductListViewRepository extends JpaRepository<ProductListViewEntity, Integer> {
    List<ProductListViewEntity> findByCategory1ContainingOrCategory2Containing(String category1, String category2);
}
