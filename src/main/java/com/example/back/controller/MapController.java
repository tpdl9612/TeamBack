package com.example.back.controller;


import com.example.back.service.KakapMapService;
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

    private final KakapMapService kakapMapService;

    @GetMapping("/search")
    public ResponseEntity<String> searchPlace(
            @RequestParam String query,
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam int radius) {
        ResponseEntity<String> responseEntity = kakapMapService.searchPlace(query, lat, lng, radius);
        return ResponseEntity.ok(responseEntity.getBody());
    }
}
