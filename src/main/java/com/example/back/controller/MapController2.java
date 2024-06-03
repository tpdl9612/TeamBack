package com.example.back.controller;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class MapController2 {

//    @Value("${naver.client.id}")
    private String clientId = "yHnbTL8e5WJbijzhlTJC";

//    @Value("${naver.client.secret}")
    private String clientSecret = "zALwPNV7B6";

    @GetMapping("/api/search")
    public ResponseEntity<String> searchPlace(
            @RequestParam String query,
            @RequestParam double lat,
            @RequestParam double lng,
            @RequestParam int radius) {

        String url = "https://openapi.naver.com/v1/search/local.json";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query", query)
                .queryParam("display", 5)
                .queryParam("start", 1)
                .queryParam("sort", "random")
                .queryParam("latitude", lat)
                .queryParam("longitude", lng)
                .queryParam("radius", radius);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class));
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
    }
}
