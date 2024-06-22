package com.example.back.entity;

import com.example.back.dto.request.order.SaveOrderItemRequestDto;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    @JsonManagedReference
    private OrderListEntity orderList;
    private String productId;
    private String title;
    @ElementCollection
    private List<String> productImageList;
    private String lowPrice;
    private String category1;
    private String category2;
    private String category3;
    private String count;
    private String userId;

    public OrderItemEntity(OrderListEntity orderList, SaveOrderItemRequestDto itemDto, String userId) {
        this.orderList = orderList;
        this.productId = itemDto.getProductId();
        this.title = itemDto.getTitle();
        this.productImageList = itemDto.getProductImageList();
        this.category1 = itemDto.getCategory1();
        this.category2 = itemDto.getCategory2();
        this.category3 = itemDto.getCategory3();
        this.lowPrice = itemDto.getLowPrice();
        this.count = itemDto.getCount();
        this.userId = userId;
    }
}
