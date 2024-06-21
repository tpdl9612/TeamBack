package com.example.back.dto.response.Question;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.AnswerEntity;
import com.example.back.entity.QuestionEntity;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;

@Getter
public class GetQuestionResponseDto  extends ResponseDto {
    private Long questionId;
    private String title;
    private String content;
    private String userId;
    private String type;
    private String email;
    private boolean answered;
    private LocalDate createdAt;

    public GetQuestionResponseDto(QuestionEntity questionEntity){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
        this.questionId = questionEntity.getQuestionId();
        this.title= questionEntity.getTitle();;
        this.content= questionEntity.getContent();
        this.createdAt=questionEntity.getCreatedAt();
        this.userId= questionEntity.getUserId();
        this.type= questionEntity.getType();
        this.email= questionEntity.getEmail();
        this.answered= questionEntity.isAnswered();
    }
    public static ResponseEntity<GetQuestionResponseDto> success(QuestionEntity questionEntity){
        GetQuestionResponseDto responseBody = new GetQuestionResponseDto(questionEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
    public static ResponseEntity<ResponseDto> notExistQuestion(){
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_QUESTION,ResponseMessage.NOT_EXISTED_QUESTION);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }




}
