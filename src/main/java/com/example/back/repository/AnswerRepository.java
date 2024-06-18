package com.example.back.repository;

import com.example.back.entity.AnswerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AnswerRepository extends JpaRepository<AnswerEntity, Long> {
    AnswerEntity findByAnswerId(Long AnswerId);




    @Query(
            value=
                    "SELECT " +
                            "B.answer_number AS answerNumber, " +
                            "B.title AS title, " +
                            "B.content AS content " +
                            "FROM answer_entity AS B " +
                            "WHERE answer_number = ?1 ",
            nativeQuery = true
    )
    AnswerEntity getAnswer(Long answerId);
}
