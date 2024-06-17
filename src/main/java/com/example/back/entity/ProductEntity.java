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
import java.util.Date;

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
    private String link;
    private String image;
    private String writeDatetime;
    private String lowPrice;
    private String userId;
    private String category1;
    private String category2;

    public ProductEntity(PostProductRequestDto dto, String userId){
        Date now = Date.from(Instant.now());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String writeDatetime = simpleDateFormat.format(now);

        this.productId = dto.getProductId();
        this.title = dto.getTitle();
        this.link = dto.getLink();
        this.image = dto.getImage();
        this.lowPrice = dto.getLowPrice();
        this.userId = userId;
        this.category1 = dto.getCategory1();
        this.category2 = dto.getCategory2();
        this.writeDatetime = writeDatetime;
    }

    public void patchBoard(PatchProductRequestDto dto) {
        this.productId = dto.getProductId();
        this.title = dto.getTitle();
        this.link = dto.getLink();
        this.image = dto.getImage();
        this.lowPrice = dto.getLowPrice();
        this.category1 = dto.getCategory1();
        this.category2 = dto.getCategory2();
    }
}
