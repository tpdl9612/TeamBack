package com.example.back.controller;

import com.example.back.dto.request.Answer.PatchAnswerRequestDto;
import com.example.back.dto.request.Answer.PostAnswerRequestDto;
import com.example.back.dto.response.Answer.*;
import com.example.back.dto.response.ResponseDto;
import com.example.back.service.AnswerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/question/answer")
public class AnswerController {
    private final AnswerService answerService;

    @PostMapping("")
    public ResponseEntity<? super PostAnswerResponseDto> postAnswer(@RequestBody @Valid PostAnswerRequestDto requestBody){
        System.out.println(requestBody);
        ResponseEntity<? super PostAnswerResponseDto> response = answerService.postAnswer(requestBody);
        return  response;
    }

    @GetMapping("/list")
    public ResponseEntity<? super GetAllAnswerResponseDto> getAllAnswers(){
        ResponseEntity<? super GetAllAnswerResponseDto> response = answerService.getAllAnswers();
        return response;
    }

    @GetMapping("/detail/{answerId}")
    public ResponseEntity<? super GetAnswerResponseDto> getAnswer(
            @PathVariable("answerId") Long answerId
    ){ ResponseEntity<? super GetAnswerResponseDto> response = answerService.getAnswer(answerId);
    return response;}

    @PatchMapping("update/{answerId}")
    public ResponseEntity<? super PatchAnswerResponseDto> patchAnswer(
            @RequestBody @Valid PatchAnswerRequestDto requestBody,
            @PathVariable("answerId") Long answerId
            ){
        ResponseEntity<? super PatchAnswerResponseDto>response = answerService.patchAnswer(requestBody, answerId);
        return response;
    }

    @DeleteMapping("/delete/{answerId}")
    public ResponseEntity<? super DeleteAnswerResponseDto> deleteAnswer(
            @PathVariable("answerId") Long answerId,
            @AuthenticationPrincipal String userId
    ){
        ResponseEntity<? super DeleteAnswerResponseDto> response = answerService.deleteAnswer(answerId);
        return response;
    }
}
