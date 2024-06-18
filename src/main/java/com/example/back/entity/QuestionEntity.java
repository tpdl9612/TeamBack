package com.example.back.entity;


import com.example.back.dto.request.Question.PatchQuestionRequestDto;
import com.example.back.dto.request.Question.PostQuestionRequestDto;
import com.example.back.dto.request.Question.QuestionRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@Entity(name="question")
@Table(name="question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questionId;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private boolean answered;

    @Column(nullable = false)
    @CreationTimestamp
    private LocalDate createdAt;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="order_item_id",nullable=false)
//    private OrderItemEntity orderItemEntity;
//    // orderItemEntity 는 DTo 에서 주문 ID를 가져와서 필요시 로딩하여 설정
//
    public QuestionEntity(){
        this.createdAt = LocalDate.now();
    }

    public QuestionEntity(QuestionRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.answered = false;
        this.createdAt = LocalDate.now();

    }
    public QuestionEntity(PostQuestionRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.answered = false;
        this.createdAt = LocalDate.now();
    }
    public void patchQuestion(PatchQuestionRequestDto dto){
        this.title= dto.getTitle();
        this.content = dto.getContent();
    }

}
