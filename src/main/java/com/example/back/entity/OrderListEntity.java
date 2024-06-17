package com.example.back.entity;

import com.example.back.dto.request.order.SaveOrderListRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "order_list")
public class OrderListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long listId;

    @Column(name = "order_id")
    private String orderId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "item_id")
    private Long itemId;

    @OneToMany(mappedBy = "orderList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<OrderItemEntity> items;

    public OrderListEntity(SaveOrderListRequestDto dto, String userId) {
        this.orderId = dto.getOrderId();
        this.userId = userId;
        this.items = dto.getItems().stream()
                .map(itemDto -> new OrderItemEntity(this, itemDto, userId))
                .collect(Collectors.toList());
    }
}

