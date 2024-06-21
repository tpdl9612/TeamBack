package com.example.back.service;

import com.example.back.dto.request.Answer.AnswerRequestDto;
import com.example.back.dto.request.Answer.PatchAnswerRequestDto;
import com.example.back.dto.request.Answer.PostAnswerRequestDto;
import com.example.back.dto.response.Answer.*;
import com.example.back.entity.AnswerEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AnswerService {
  ResponseEntity<? super GetAnswerResponseDto> getAnswer(Long questionId);
    ResponseEntity<? super PostAnswerResponseDto> postAnswer(PostAnswerRequestDto dto);
    ResponseEntity<? super PatchAnswerResponseDto> patchAnswer(PatchAnswerRequestDto dto, Long answerId);
    ResponseEntity<? super DeleteAnswerResponseDto> deleteAnswer(Long AnswerId);
    ResponseEntity<? super GetAllAnswerResponseDto> getAllAnswers();

}
