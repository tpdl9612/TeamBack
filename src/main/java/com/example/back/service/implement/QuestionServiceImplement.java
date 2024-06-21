package com.example.back.service.implement;


import com.example.back.dto.request.Question.PatchQuestionRequestDto;
import com.example.back.dto.request.Question.PostQuestionRequestDto;
import com.example.back.dto.request.Question.QuestionRequestDto;
import com.example.back.dto.response.Question.*;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.QuestionEntity;
import com.example.back.entity.QuestionEntity;
import com.example.back.repository.QuestionRepository;
import com.example.back.service.QuestionService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class QuestionServiceImplement implements QuestionService {
private final QuestionRepository questionRepository;

    @Override
    public ResponseEntity<? super GetQuestionResponseDto> getQuestion(Long QuestionId){
        QuestionEntity questionEntity = null;
        try{
            questionEntity = questionRepository.getQuestion(QuestionId);
            if(questionEntity == null) return GetQuestionResponseDto.notExistQuestion();
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        } return GetQuestionResponseDto.success(questionEntity);
    }
    @Override
    public ResponseEntity<? super PostQuestionResponseDto> postQuestion(PostQuestionRequestDto dto){
        try{
            QuestionEntity questionEntity = new QuestionEntity(dto);
            questionRepository.save(questionEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PostQuestionResponseDto.success();
    }
    @Override
    public ResponseEntity<? super PatchQuestionResponseDto> patchQuestion(PatchQuestionRequestDto dto, Long QuestionId){
        try{
            QuestionEntity questionEntity = questionRepository.findByQuestionId(QuestionId);
            if(questionEntity == null) return PatchQuestionResponseDto.notExistQuestion();

            questionEntity.patchQuestion(dto);
            questionRepository.save(questionEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        } return PatchQuestionResponseDto.success();
    }

    @Override
    public ResponseEntity<? super DeleteQuestionResponseDto> deleteQuestion(Long QuestionId){
        try{
            QuestionEntity questionEntity = questionRepository.findByQuestionId(QuestionId);
            if(questionEntity == null) return DeleteQuestionResponseDto.notExistedQuestion();

            questionRepository.delete(questionEntity);
        } catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        } return DeleteQuestionResponseDto.success();
    }
    @Override
    public ResponseEntity<? super GetAllQuestionResponseDto> getAllQuestions(){
        List<QuestionEntity> questions = null;
        try{
            questions = questionRepository.findAll();
        } catch(Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }return GetAllQuestionResponseDto.success(questions);
    }



}
