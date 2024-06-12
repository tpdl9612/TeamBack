package com.example.back.service.implement;

import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.payment.PaymentResponseDto;
import com.example.back.entity.PaymentEntity;
import com.example.back.entity.ProductEntity;
import com.example.back.repository.PaymentRepository;
import com.example.back.repository.ProductRepository;
import com.example.back.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImplement implements PaymentService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private final PaymentRepository paymentRepository;
    private final ProductRepository productRepository;

    @Override
    public JSONObject confirmPayment(String jsonBody) throws Exception {
        JSONParser parser = new JSONParser();
        String orderId;
        String amountStr;
        String paymentKey;
        try {
            // 클라이언트에서 받은 JSON 요청 바디입니다.
            JSONObject requestData = (JSONObject) parser.parse(jsonBody);
            paymentKey = (String) requestData.get("paymentKey");
            orderId = (String) requestData.get("orderId");
            Object amountObject = requestData.get("amount");
            if (amountObject instanceof Long) {
                amountStr = Long.toString((Long) amountObject);
            } else if (amountObject instanceof Integer) {
                amountStr = Integer.toString((Integer) amountObject);
            } else {
                throw new RuntimeException("Invalid amount type: " + amountObject.getClass().getName());
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        JSONObject obj = new JSONObject();
        obj.put("orderId", orderId);
        obj.put("amount", amountStr);
        obj.put("paymentKey", paymentKey);

        String widgetSecretKey = "test_gsk_docs_OaPz8L5KdmQXkzRz3y47BMw6";

        // 토스페이먼츠 API는 시크릿 키를 사용자 ID로 사용하고, 비밀번호는 사용하지 않습니다.
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encodedBytes = encoder.encode((widgetSecretKey + ":").getBytes(StandardCharsets.UTF_8));
        String authorizations = "Basic " + new String(encodedBytes);

        // 결제 승인 API를 호출합니다.
        URL url = new URL("https://api.tosspayments.com/v1/payments/confirm");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestProperty("Authorization", authorizations);
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestMethod("POST");
        connection.setDoOutput(true);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(obj.toString().getBytes(StandardCharsets.UTF_8));

        int code = connection.getResponseCode();
        boolean isSuccess = code == 200;

        InputStream responseStream = isSuccess ? connection.getInputStream() : connection.getErrorStream();
        Reader reader = new InputStreamReader(responseStream, StandardCharsets.UTF_8);
        JSONObject jsonObject = (JSONObject) parser.parse(reader);
        responseStream.close();

        return jsonObject;
    }

    @Override
    public ResponseEntity<? super PaymentResponseDto> savePaymentInfo(JSONObject paymentInfo) {
        String orderId = (String) paymentInfo.get("orderId");
        //TODO: productIds를 List<Long>으로 받아오는 방법을 찾아보세요.
        List<Long> productIds = (List<Long>) paymentInfo.get("productIds");

        if (paymentRepository.existsByOrderId(orderId)) {
            return PaymentResponseDto.duplicatedOrder();
        }
        PaymentEntity paymentEntity = new PaymentEntity();
        List<ProductEntity> productEntities = new ArrayList<>();
        try{
            paymentEntity.setOrderId((String) paymentInfo.get("orderId"));
            paymentEntity.setCustomerId((String) paymentInfo.get("customerId"));
            paymentEntity.setCustomerName((String) paymentInfo.get("customerName"));
            paymentEntity.setCustomerEmail((String) paymentInfo.get("customerEmail"));
            paymentEntity.setCustomerAddress((String) paymentInfo.get("customerAddress"));
            paymentEntity.setCustomerPhone((String) paymentInfo.get("customerPhone"));
            paymentEntity.setProductIds(productIds);
            paymentEntity.setAmount((String) paymentInfo.get("amount"));
            paymentEntity.setPaymentKey((String) paymentInfo.get("paymentKey"));

            paymentRepository.save(paymentEntity);

            for (Long productId : productIds) {
                Optional<ProductEntity> productEntityOptional = productRepository.findById(productId);
                productEntityOptional.ifPresent(productEntities::add);
            }
            productRepository.deleteAll(productEntities);
        }catch (Exception exception){
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return PaymentResponseDto.success();
    }
}
