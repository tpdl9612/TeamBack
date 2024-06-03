package com.example.back.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface KakapMapService {
    ResponseEntity<String> searchPlace(String query, double lat, double lng, int radius);
}