package com.example.back.repository;

import com.example.back.entity.ProductEntity;
import com.example.back.repository.resultSet.GetProductResultSet;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, String> {

    boolean existsByProductId(String productId);
    ProductEntity findByProductId(String productId);
    @Transactional
    void deleteByWriterId(String userId);

    @Query(
            value=
                    "SELECT " +
                            "P.product_id AS productId, " +
                            "P.title AS title, " +
//                            "P.content AS content, " +
                            "P.link AS link, " +
                            "P.write_datetime AS writeDatetime, " +
                            "P.writer_id AS writerId, " +
                            "U.nickname AS writerNickname, " +
                            "FROM product AS P " +
                            "INNER JOIN user AS U " +
                            "ON P.user_id = U.user_id " +
                            "WHERE product_id = ?1 ",
            nativeQuery = true
    )
    GetProductResultSet getProduct(String productId);
}

