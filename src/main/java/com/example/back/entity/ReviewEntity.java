package com.example.back.entity;

import com.example.back.dto.request.Answer.AnswerRequestDto;
import com.example.back.dto.request.Answer.PostAnswerRequestDto;
import com.example.back.dto.request.product.PostProductRequestDto;
import com.example.back.dto.request.review.PostReviewRequestDto;
import com.example.back.dto.request.review.ReviewRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="review")
@Table(name="review")
public class ReviewEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reviewId;

    @NotNull
    private String content;

    @NotNull
    private String userId;

    private String writeDatetime;

    @ManyToOne
    @JoinColumn(name="product_id", nullable =false)
    private ProductEntity product;

    public ReviewEntity(ReviewRequestDto dto, String userId, ProductEntity product){
        this.product = product;
        this.content = dto.getContent();
        this.userId = userId;
        this.writeDatetime = getCurrentFormattedDateTime();
    }

    public ReviewEntity(PostReviewRequestDto dto){
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.writeDatetime = getCurrentFormattedDateTime();
    }

    private String getCurrentFormattedDateTime() {
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(now);
    }
}
