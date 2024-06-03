package com.example.back.service;

import com.example.back.dto.response.map.GetMapResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface NaverMapService {
    ResponseEntity<GetMapResponseDto> getMapData(String query);
}