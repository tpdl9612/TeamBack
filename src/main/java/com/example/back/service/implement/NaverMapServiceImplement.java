package com.example.back.service.implement;

import com.example.back.dto.response.map.GetMapResponseDto;
import com.example.back.service.NaverMapService;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class NaverMapServiceImplement implements NaverMapService {

//    @Value("${naver.map.client.id}")
    private String clientId = "okgswrh2md";
//    @Value("${naver.map.client.secret}")
    private String clientSecret = "ID2ipruXGvhNum0xMcZFKhxNnoEBv1wceHwRhEjG";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Override
    public ResponseEntity<GetMapResponseDto> getMapData(String query) {
        String url = UriComponentsBuilder.fromHttpUrl("https://naveropenapi.apigw.ntruss.com/map-place/v1/search")
                .queryParam("query", query)
                .queryParam("coordinate", "127.105432,20.359595")
                .toUriString();

        HttpEntity<String> entity = createHttpEntity();

        try {
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
            JsonNode responseBody = objectMapper.readTree(response.getBody());

            List<GetMapResponseDto.Place> places = new ArrayList<>();
            JsonNode items = responseBody.path("items");
            if (items.isArray()) {
                for (JsonNode item : items) {
                    GetMapResponseDto.Place place = new GetMapResponseDto.Place();
                    place.setName(item.path("title").asText());
                    place.setLat(item.path("mapy").asDouble());
                    place.setLng(item.path("mapx").asDouble());
                    places.add(place);
                }
            }

            GetMapResponseDto responseDto = new GetMapResponseDto();
            responseDto.setData(places);

            return ResponseEntity.ok(responseDto);
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
            return new ResponseEntity<>(e.getStatusCode());
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    private HttpEntity<String> createHttpEntity() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("X-NCP-APIGW-API-KEY-ID", clientId);
        headers.set("X-NCP-APIGW-API-KEY", clientSecret);
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new HttpEntity<>(headers);
    }
}

