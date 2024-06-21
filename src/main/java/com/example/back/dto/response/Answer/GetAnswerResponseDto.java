package com.example.back.dto.response.Answer;


import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.AnswerEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class GetAnswerResponseDto extends ResponseDto {
    private Long answerId;
    private String content;
    private String userId;
    private LocalDateTime createdAt;
    private Long questionId;
public GetAnswerResponseDto(AnswerEntity answerEntity){
    super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    this.answerId = answerEntity.getAnswerId();
    this.content = answerEntity.getContent();
    this.userId = answerEntity.getUserId();
    this.createdAt = answerEntity.getCreatedAt();
//    if(answerEntity.getQuestion() != null){
//        this.questionId = answerEntity.getQuestion().getQuestionId();
//    } else{this.questionId = null;}
}
public static ResponseEntity<GetAnswerResponseDto> success(AnswerEntity answerEntity){
    GetAnswerResponseDto responseBody = new GetAnswerResponseDto(answerEntity);
    return ResponseEntity.status(HttpStatus.OK).body(responseBody);
}
public static ResponseEntity<ResponseDto> notExistAnswer(){
    ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_ANSWER,ResponseMessage.NOT_EXISTED_ANSWER);
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
}



}
