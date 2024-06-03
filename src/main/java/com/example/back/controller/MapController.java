package com.example.back.controller;


import com.example.back.service.KakaoMapService;
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

    private final KakaoMapService kakaoMapService;

    @GetMapping("/search")
    public ResponseEntity<String> searchPlaces(@RequestParam double lat, @RequestParam double lng, @RequestParam String query) {
        return kakaoMapService.searchPlace(lat, lng, query);
    }
}
