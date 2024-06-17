package com.example.back.entity;

import com.example.back.dto.request.product.PostReviewRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "review")
@Table(name = "review")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNumber;
    private String review;
    private String writeDatetime;
    private String userId;
    private String productId;

    public ReviewEntity(PostReviewRequestDto dto, String productId, String userId) {

        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.review = dto.getReview();
        this.writeDatetime = writeDatetime;
        this.userId = userId;
        this.productId = productId;
    }
}
