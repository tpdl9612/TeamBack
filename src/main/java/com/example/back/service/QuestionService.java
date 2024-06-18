package com.example.back.service;


import com.example.back.dto.request.Question.PatchQuestionRequestDto;
import com.example.back.dto.request.Question.PostQuestionRequestDto;
import com.example.back.dto.request.Question.QuestionRequestDto;
import com.example.back.dto.response.Question.*;
import com.example.back.entity.QuestionEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public interface QuestionService {
    ResponseEntity<? super GetQuestionResponseDto> getQuestion(Long QuestionId);
    ResponseEntity<? super PostQuestionResponseDto> postQuestion(PostQuestionRequestDto dto);
    ResponseEntity<? super PatchQuestionResponseDto> patchQuestion(PatchQuestionRequestDto dto, Long QuestionId);
    ResponseEntity<? super DeleteQuestionResponseDto> deleteQuestion(Long QuestionId);
    ResponseEntity<? super GetAllQuestionResponseDto> getAllQuestions();


}
