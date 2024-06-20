package com.example.back.service.implement;

import com.example.back.dto.request.cart.SaveCartRequestDto;
import com.example.back.dto.response.ResponseDto;
import com.example.back.dto.response.cart.DeleteCartResponseDto;
import com.example.back.dto.response.cart.ListCartResponseDto;
import com.example.back.dto.response.cart.SaveCartResponseDto;
import com.example.back.entity.CartEntity;
import com.example.back.repository.CartRepository;
import com.example.back.repository.UserRepository;
import com.example.back.service.CartService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CartServiceImplement implements CartService {

    private final RestTemplate restTemplate;
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    @Override
    public ResponseEntity<? super SaveCartResponseDto> saveProducts(SaveCartRequestDto dto, String userId) {
        try {
            boolean existedUser = userRepository.existsByUserId(userId);
            if (!existedUser) return SaveCartResponseDto.notExistUser();

            CartEntity entity = cartRepository.findByProductId(dto.getProductId());
            if(entity != null) {
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
