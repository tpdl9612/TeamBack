package com.example.back.entity;


import com.example.back.dto.request.Answer.AnswerRequestDto;
import com.example.back.dto.request.Answer.PatchAnswerRequestDto;
import com.example.back.dto.request.Answer.PostAnswerRequestDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="answer")
@Table(name="answer")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @NotNull
    private String content;

    @NotNull
    private String userId;

    @NotNull
    @CreationTimestamp
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", nullable =false)
    private QuestionEntity question;

    public AnswerEntity(){
        this.createdAt = LocalDateTime.now();
    }
    public AnswerEntity(AnswerRequestDto dto, String userId, QuestionEntity question){
        this.content = dto.getContent();
        this.userId = userId;
        this.question = question;
        this.createdAt = LocalDateTime.now();
    }
    public AnswerEntity(PostAnswerRequestDto dto){
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.createdAt = LocalDateTime.now();
    }
    public void patchAnswer(PatchAnswerRequestDto dto){
        this.content = dto.getContent();
    }

}
