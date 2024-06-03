package com.example.back.controller;

import com.example.back.dto.response.map.GetMapResponseDto;
import com.example.back.service.NaverMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/map")
@RequiredArgsConstructor
public class MapController {

    private final NaverMapService naverMapService;

    @GetMapping("/search")
    public ResponseEntity<? super GetMapResponseDto> getMapData(@RequestParam String query) {
        ResponseEntity<? super GetMapResponseDto> response = naverMapService.getMapData(query);
        return response;
    }
}

