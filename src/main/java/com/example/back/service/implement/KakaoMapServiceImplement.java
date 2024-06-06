package com.example.back.service.implement;


import com.example.back.service.KakaoMapService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KakaoMapServiceImplement implements KakaoMapService {

//    @Value("${kakao.api.key}")
    private String apiKey = "38ee3c6f0ecce771ae58db71c6121ee0";

    private final RestTemplate restTemplate;

    @Override
    public ResponseEntity<String> searchPlace(double lat, double lng, String query) {
        String url = "https://dapi.kakao.com/v2/local/search/keyword.json?query=" + query + "&x=" + lng + "&y=" + lat + "&radius=1000";

        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "KakaoAK " + apiKey);

        HttpEntity<String> entity = new HttpEntity<>(headers);
        return restTemplate.exchange(url, org.springframework.http.HttpMethod.GET, entity, String.class);
    }
}

