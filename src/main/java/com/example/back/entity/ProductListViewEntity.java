package com.example.back.entity;

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
@Entity(name = "product_list_view")
@Table(name = "product_list_view")
public class ProductListViewEntity {

    @Id
    private int id;
    private String productId;
    private String title;
    private String content;
    private String image;
    private String lowPrice;
    private String category1;
    private String category2;
    private String userId;
    private String writerNickname;
    private String writeDatetime;

}
