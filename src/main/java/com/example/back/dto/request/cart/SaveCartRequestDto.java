package com.example.back.dto.request.cart;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaveCartRequestDto {

    private Long productId;
    private String title;
    private List<String> productImageList;
    private List<String> secondaryProductImageList;
    private String lowPrice;
    private String userId;
    private String category1;
    private String category2;
    private String category3;
    private String count;
}
