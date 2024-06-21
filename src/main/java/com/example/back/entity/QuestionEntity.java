package com.example.back.entity;


import com.example.back.dto.request.Question.PatchQuestionRequestDto;
import com.example.back.dto.request.Question.PostQuestionRequestDto;
import com.example.back.dto.request.Question.QuestionRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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
    @NotNull
    private String title;
    @NotNull
    private String content;

    @NotNull
    private String userId;

    @NotNull
    private String type;

    @NotNull
    private String email;

    @NotNull
    private boolean answered;

    @NotNull
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
        this.type=dto.getType();
        this.email=dto.getEmail();

    }
    public QuestionEntity(PostQuestionRequestDto dto){
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.answered = false;
        this.createdAt = LocalDate.now();
        this.type=dto.getType();
        this.email=dto.getEmail();
    }
    public void patchQuestion(PatchQuestionRequestDto dto){
        this.title= dto.getTitle();
        this.content = dto.getContent();
        this.type=dto.getType();
        this.email=dto.getEmail();
    }

}
