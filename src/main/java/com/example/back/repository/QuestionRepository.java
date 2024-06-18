package com.example.back.repository;

import com.example.back.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    @Query(
            value=
                    "SELECT " +
                            "B.question_number AS questionNumber, " +
                            "B.title AS title, " +
                            "B.content AS content " +
                            "FROM question_entity AS B " +
                            "WHERE question_number = ?1 ",
            nativeQuery = true
    )
    QuestionEntity getQuestion(Long QuestionId);
    QuestionEntity findByQuestionId(Long QuestionId);
}
