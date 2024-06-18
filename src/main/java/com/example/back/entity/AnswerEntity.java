package com.example.back.entity;


import com.example.back.dto.request.Answer.AnswerRequestDto;
import com.example.back.dto.request.Answer.PatchAnswerRequestDto;
import com.example.back.dto.request.Answer.PostAnswerRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Entity(name="answer")
@Table(name="answer")
public class AnswerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answerId;

    @Column(nullable=false)
    private String content;

    @Column(nullable=false)
    private String userId;

    @Column(nullable=false)
    @CreationTimestamp
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="question_id", nullable =false)
    private QuestionEntity question;

    public AnswerEntity(){
        this.createdAt = LocalDate.now();
    }
    public AnswerEntity(AnswerRequestDto dto, String userId, QuestionEntity question){
        this.content = dto.getContent();
        this.userId = userId;
        this.question = question;
        this.createdAt = LocalDate.now();
    }
    public AnswerEntity(PostAnswerRequestDto dto){
        this.content = dto.getContent();
        this.userId = dto.getUserId();
        this.question = question;
        this.createdAt = LocalDate.now();
    }
    public void patchAnswer(PatchAnswerRequestDto dto){
        this.content = dto.getContent();
    }

}
