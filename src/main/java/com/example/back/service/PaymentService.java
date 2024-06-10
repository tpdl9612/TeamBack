package com.example.back.service;

import org.json.simple.JSONObject;

public interface PaymentService {
    JSONObject confirmPayment(String jsonBody) throws Exception;
}
