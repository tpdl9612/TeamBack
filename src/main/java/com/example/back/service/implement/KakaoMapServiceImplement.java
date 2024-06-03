package com.example.back.service.implement;


import com.example.back.service.KakapMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
@RequiredArgsConstructor
public class KakaoMapServiceImplement implements KakapMapService {

    @Value("${naver.map.client.id}")
    private String clientId;
    @Value("${naver.map.client.secret}")
    private String clientSecret;

    public ResponseEntity<String> searchPlace(String query, double lat, double lng, int radius) {
        String url = "https://openapi.naver.com/v1/search/local.json";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("query", query)
                .queryParam("display", 5)
                .queryParam("start", 56)
                .queryParam("sort", "random");
//                .queryParam("latitude", lat)
//                .queryParam("longitude", lng)
//                .queryParam("radius", radius);

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", clientId);
        headers.set("X-Naver-Client-Secret", clientSecret);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);
    }
}

