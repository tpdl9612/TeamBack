package com.example.back.entity;

import jakarta.persistence.Column;
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
    @Column(name = "id")
    private int id;

    @Column(name = "product_id")
    private String productId;
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;
    @Column(name = "low_price")
    private String lowPrice;
    @Column(name = "title_image")
    private String titleImage;
    @Column(name = "secondary_image")
    private String secondaryImage;
    @Column(name = "category1")
    private String category1;
    @Column(name = "category2")
    private String category2;
    @Column(name = "category3")
    private String category3;
    @Column(name = "user_id")
    private String userId;
    @Column(name = "write_datetime")
    private String writeDatetime;

    public List<String> getTitleImage() {
        return List.of(titleImage.split(","));
    }

    public List<String> getSecondaryImage() {
        return List.of(secondaryImage.split(","));
    }
}
