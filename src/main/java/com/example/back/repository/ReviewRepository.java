package com.example.back.repository;

import com.example.back.entity.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Long> {
    ReviewEntity findByReviewId(Long ReviewId);

    @Query(
            value=
                    "SELECT * " +
                            "FROM product AS B " +
                            "WHERE product_id = ?1 ",
            nativeQuery = true
    )
    List<ReviewEntity> getReview(String productId);
}
