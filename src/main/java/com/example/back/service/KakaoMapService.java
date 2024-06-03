package com.example.back.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface KakaoMapService {
    ResponseEntity<String> searchPlace(double lat, double lng, String query);
}