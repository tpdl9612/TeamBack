package com.example.back.dto.response.payment;

import com.example.back.common.ResponseCode;
import com.example.back.common.ResponseMessage;
import com.example.back.dto.response.ResponseDto;
import com.example.back.entity.PaymentEntity;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
public class GetPaymentResponseDto extends ResponseDto {

    private final String orderId;
    private final String customerName;
    private final String customerEmail;
    private final String customerPhone;
    private final String customerPostcode;
    private final String customerAddress;
    private final String amount;
    private final String paymentKey;

    public GetPaymentResponseDto(PaymentEntity paymentEntity) {
        this.orderId = paymentEntity.getOrderId();
        this.customerName = paymentEntity.getCustomerName();
        this.customerEmail = paymentEntity.getCustomerEmail();
        this.customerPhone = paymentEntity.getCustomerPhone();
        this.customerPostcode = paymentEntity.getCustomerPostcode();
        this.customerAddress = paymentEntity.getCustomerAddress();
        this.amount = paymentEntity.getAmount();
        this.paymentKey = paymentEntity.getPaymentKey();
    }

    public static ResponseEntity<GetPaymentResponseDto> success(PaymentEntity paymentEntity){
        GetPaymentResponseDto responseBody = new GetPaymentResponseDto(paymentEntity);
        return ResponseEntity.status(HttpStatus.OK).body(responseBody);
    }

    public static ResponseEntity<ResponseDto> notExistPayment() {
        ResponseDto responseBody = new ResponseDto(ResponseCode.NOT_EXISTED_PAYMENT, ResponseMessage.NOT_EXISTED_PAYMENT);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseBody);
    }
}
