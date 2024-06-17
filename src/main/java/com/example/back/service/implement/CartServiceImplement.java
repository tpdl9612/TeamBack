package com.example.back.service.implement;

import com.example.back.dto.request.cart.SaveCartRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.cart.DeleteCartResponseDto;
import com.example.back.dto.response.cart.ListCartResponseDto;
import com.example.back.dto.response.cart.SaveCartResponseDto;
import com.example.back.dto.response.product.GetSearchProductResponseDto;
import com.example.back.entity.CartEntity;
import com.example.back.repository.CartRepository;
import com.example.back.repository.UserRepository;
import com.example.back.service.CartService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartServiceImplement implements CartService {

    private final String CLIENT_ID = "yHnbTL8e5WJbijzhlTJC";
    private final String CLIENT_SECRET = "zALwPNV7B6";

    private final RestTemplate restTemplate;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super GetSearchProductResponseDto> searchProductsFromApi(String keyword) {
        String url = "https://openapi.naver.com/v1/search/shop.json?query=" + keyword + "&display=100";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-Naver-Client-Id", CLIENT_ID);
        headers.set("X-Naver-Client-Secret", CLIENT_SECRET);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<NaverResponse> responseEntity = restTemplate.exchange(url, HttpMethod.GET, entity, NaverResponse.class);
        NaverResponse naverResponse = responseEntity.getBody();

        if (naverResponse != null && naverResponse.getItems() != null) {
            List<CartEntity> productEntities = naverResponse.getItems().stream().map(item -> {
                if ("네이버".equals(item.getMallName())) {
                    CartEntity product = new CartEntity();
                    product.setProductId(item.getProductId());
                    product.setTitle(removeHtmlTags(item.getTitle()));
                    product.setLink(item.getLink());
                    product.setImage(item.getImage());
                    product.setLowPrice(item.getLprice());
                    product.setCategory1(item.getCategory1());
                    product.setCategory2(item.getCategory2());
                    product.setMallName(item.getMallName());
                    return product;
                }
                return null;
            }).filter(Objects::nonNull).collect(Collectors.toList());
            return GetSearchProductResponseDto.success(productEntities);
        }
        return GetSearchProductResponseDto.fail();
    }

    @Override
    public ResponseEntity<? super SaveCartResponseDto> saveProducts(SaveCartRequestDto dto, String userId) {
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return SaveCartResponseDto.notExistUser();

            CartEntity entity = cartRepository.findByProductId(dto.getProductId());
            if(entity != null) {
                System.out.println(dto.getProductId());
                System.out.println(entity.getProductId());
                if (entity.getProductId().equals(dto.getProductId())) return SaveCartResponseDto.duplicatedProduct();
            }
            CartEntity cartEntity = new CartEntity(dto, userId);
            cartRepository.save(cartEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return SaveCartResponseDto.success();
    }

    @Override
    public ResponseEntity<? super ListCartResponseDto> getUserCartList(String userId) {
        List<CartEntity> cartListViewEntities = new ArrayList<>();
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return ListCartResponseDto.notExistUser();

            cartListViewEntities = cartRepository.findByUserId(userId);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return ListCartResponseDto.success(cartListViewEntities);
    }

    @Override
    public ResponseEntity<? super DeleteCartResponseDto> deleteProduct(Long productId) {
        try {
            CartEntity cartEntity = cartRepository.findByProductId(productId);
            if (cartEntity == null) return DeleteCartResponseDto.notExistedProduct();

            cartRepository.delete(cartEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ResponseDto.databaseError();
        }
        return DeleteCartResponseDto.success();
    }


    private static class NaverResponse {
        private List<Item> items;

        public List<Item> getItems() {
            return items;
        }

        public void setItems(List<Item> items) {
            this.items = items;
        }
    }

    @Getter
    @Setter
    private static class Item {
        private Long productId;
        private String title;
        private String link;
        private String image;
        private String lprice;
        private int count;
        private String category1;
        private String category2;
        private String mallName;
    }

    private String removeHtmlTags(String html) {
        return html.replaceAll("\\<.*?\\>", "");
    }
}
