package com.example.back.entity;

import com.example.back.dto.request.order.SaveOrderListRequestDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

    @Column(name = "order_datetime")
    private String orderDatetime;

    @OneToMany(mappedBy = "orderList", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    private List<OrderItemEntity> items;

    public OrderListEntity(SaveOrderListRequestDto dto, String userId) throws ParseException {
        this.orderId = dto.getOrderId();
        this.userId = userId;
        this.items = dto.getItems().stream()
                .map(itemDto -> new OrderItemEntity(this, itemDto, userId))
                .collect(Collectors.toList());
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat targetFormat = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        Date paymentDatetime = originalFormat.parse(dto.getOrderDatetime());
        this.orderDatetime = targetFormat.format(paymentDatetime);

    }
}

