package com.example.back.repository;

import com.example.back.entity.ProductEntity;
import com.example.back.repository.resultSet.GetProductResultSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    boolean existsByProductId(String productId);
    ProductEntity findByProductId(String productId);

    @Query(
            value=
                    "SELECT " +
                            "P.id AS id, " +
                            "P.product_id AS productId, " +
                            "P.title AS title, " +
                            "P.content AS content, " +
                            "P.link AS link, " +
                            "P.write_datetime AS writeDatetime, " +
                            "P.user_id AS userId, " +
                            "P.low_price AS lowPrice, " +
                            "P.category1 AS category1, " +
                            "P.category2 AS category2, " +
                            "FROM product AS P " +
                            "INNER JOIN user AS U " +
                            "ON P.user_id = U.user_id " +
                            "WHERE product_id = ?1 ",
            nativeQuery = true
    )
    GetProductResultSet getProduct(String productId);
}

