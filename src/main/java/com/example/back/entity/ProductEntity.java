package com.example.back.entity;

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
@Entity(name="product")
@Table(name="product")
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
}