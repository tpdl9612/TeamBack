package com.example.back.controller;

import com.example.back.dto.response.payment.PaymentResponseDto;
import com.example.back.service.PaymentService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/payment")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/confirm")
    public ResponseEntity<JSONObject> confirmPayment(@RequestBody String jsonBody) throws Exception {
        JSONObject response = paymentService.confirmPayment(jsonBody);
        return ResponseEntity.status(response.containsKey("errorCode") ? 400 : 200).body(response);
    }

    @GetMapping("/success")
    public ResponseEntity<JSONObject> paymentSuccess() {
        JSONObject response = new JSONObject();
        response.put("status", "success");
        response.put("message", "Payment was successful.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/")
    public ResponseEntity<JSONObject> index() {
        JSONObject response = new JSONObject();
        response.put("message", "Welcome to the checkout page.");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/fail")
    public ResponseEntity<JSONObject> failPayment(HttpServletRequest request) {
        String failCode = request.getParameter("code");
        String failMessage = request.getParameter("message");

        JSONObject response = new JSONObject();
        response.put("status", "fail");
        response.put("code", failCode);
        response.put("message", failMessage);

        return ResponseEntity.status(400).body(response);
    }

    @PostMapping("/savePaymentInfo")
    public ResponseEntity<? super PaymentResponseDto> savePaymentInfo(@RequestBody JSONObject paymentInfo) {
        ResponseEntity<? super PaymentResponseDto> response = paymentService.savePaymentInfo(paymentInfo);
        return response;
    }
}
