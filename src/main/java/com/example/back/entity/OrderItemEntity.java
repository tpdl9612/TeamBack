package com.example.back.entity;

import com.example.back.dto.request.order.SaveOrderItemRequestDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_item")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long itemId;

    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private OrderListEntity orderList;

    private String title;
    private String link;
    private String image;
    private String totalPrice;
    private String category1;
    private String category2;
    private String category3;
    private String count;
    private String userId;

    public OrderItemEntity(OrderListEntity orderList, SaveOrderItemRequestDto itemDto, String userId) {
        this.orderList = orderList;
        this.title = itemDto.getTitle();
        this.link = itemDto.getLink();
        this.image = itemDto.getImage();
        this.totalPrice = itemDto.getTotalPrice();
        this.category1 = itemDto.getCategory1();
        this.category2 = itemDto.getCategory2();
        this.category3 = itemDto.getCategory3();
        this.count = itemDto.getCount();
        this.userId = userId;
    }
}
