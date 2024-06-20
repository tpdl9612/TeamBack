package com.example.back.repository;

import com.example.back.entity.QuestionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long> {
    @Query(
            value=
                    //                            "B.question_id AS question_id, " +
//                            "B.title AS title, " +
//                            "B.content AS content, " +
//                            "B.userId AS userId, " +
                            "SELECT * " +
                            "FROM question AS B " +
                            "WHERE question_id = ?1 ",
            nativeQuery = true
    )
    QuestionEntity getQuestion(Long QuestionId);
    QuestionEntity findByQuestionId(Long QuestionId);
}
