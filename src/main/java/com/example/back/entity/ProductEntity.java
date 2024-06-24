package com.example.back.entity;

import com.example.back.dto.request.product.PatchProductRequestDto;
import com.example.back.dto.request.product.PostProductRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productId;
    private String title;
    private String content;
    private String writeDatetime;
    private String lowPrice;
    private String userId;
    private String category1;
    private String category2;
    private String category3;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private OrderListEntity orderId;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<ReviewEntity> reviews = new ArrayList<>();

    public ProductEntity(PostProductRequestDto dto, String userId){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.productId = dto.getProductId();
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.lowPrice = dto.getLowPrice();
        this.userId = userId;
        this.category1 = dto.getCategory1();
        this.category2 = dto.getCategory2();
        this.category3 = dto.getCategory3();
        this.writeDatetime = writeDatetime;
    }

    public void patchProduct(PatchProductRequestDto dto) {
        this.productId = dto.getProductId();
        this.title = dto.getTitle();
        this.content = dto.getContent();
        this.lowPrice = dto.getLowPrice();
        this.category1 = dto.getCategory1();
        this.category2 = dto.getCategory2();
        this.category3 = dto.getCategory3();
    }
}
