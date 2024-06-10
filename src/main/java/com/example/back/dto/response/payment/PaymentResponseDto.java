package com.example.back.dto.response.payment;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.auth.EmailCertificationResponseDto;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class PaymentResponseDto extends ResponseDto {

    private PaymentResponseDto(){
        super(ResponseCode.SUCCESS, ResponseMessage.SUCCESS);
    }

    public static ResponseEntity<PaymentResponseDto> success(){
        PaymentResponseDto responseBody = new PaymentResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }
}
