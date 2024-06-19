package com.example.back.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

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
    private String lowPrice;
    private List<String> titleImage;
    private List<String> secondaryImage;
    private String category1;
    private String category2;
    private String category3;
    private String userId;
    private String writeDatetime;

}
