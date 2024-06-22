package com.example.back.dto.response.order;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class SaveOrderListResponseDto extends ResponseDto {

    private SaveOrderListResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<SaveOrderListResponseDto> success(){
        SaveOrderListResponseDto responseBody = new SaveOrderListResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
