package com.example.back.dto.response.Question;


import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.QuestionEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Getter
public class GetAllQuestionResponseDto extends ResponseDto {
    private List<QuestionEntity> questions;

    public GetAllQuestionResponseDto(List<QuestionEntity> questions){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.questions= questions;
    }
    public static ResponseEntity<GetAllQuestionResponseDto> success(List<QuestionEntity> questions){
        GetAllQuestionResponseDto responseBody = new GetAllQuestionResponseDto(questions);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }



}
