package com.example.back.entity;

import com.example.back.dto.request.product.SaveProductRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "product")
@Table(name = "product")
public class ProductEntity {
    @Id
    @Column(name = "product_id")
    private Long productId;
    private String userId;
    private String title;
    private String link;
    private String image;
    private String lowPrice;
    private String category1;
    private String category2;
    private String mallName;

    public ProductEntity(SaveProductRequestDto dto, String userId) {
        this.productId = dto.getProductId();
        this.userId = userId;
        this.title = dto.getTitle();
        this.link = dto.getLink();
        this.image = dto.getImage();
        this.lowPrice = dto.getLowPrice();
        this.category1 = dto.getCategory1();
        this.category2 = dto.getCategory2();
        this.mallName = dto.getMallName();
    }
}