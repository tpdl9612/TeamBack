package com.example.back.dto.request.order;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaveOrderItemRequestDto {
    private String title;
    private String link;
    private String image;
    private String totalPrice;
    private String category1;
    private String category2;
    private String category3;
    private String count;
}
