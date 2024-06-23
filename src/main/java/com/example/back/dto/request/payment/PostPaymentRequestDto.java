package com.example.back.dto.request.payment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostPaymentRequestDto {
    private String orderId;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerPostcode;
    private String customerAddress;
    private String amount;
    private String paymentKey;
}
