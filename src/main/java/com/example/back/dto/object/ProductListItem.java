package com.example.back.dto.object;

import com.example.back.entity.ProductListViewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductListItem {

    private int id;
    private String productId;
    private String title;
    private String content;
    private List<String> titleImage;
    private List<String> secondaryImage;
    private String lowPrice;
    private String category1;
    private String category2;
    private String category3;
    private String userId;
    private String writeDatetime;

    public ProductListItem(ProductListViewEntity productListViewEntity) {
        this.productId = productListViewEntity.getProductId();
        this.title = productListViewEntity.getTitle();
        this.content = productListViewEntity.getContent();
        this.titleImage = productListViewEntity.getTitleImage();
        this.secondaryImage = productListViewEntity.getSecondaryImage();
        this.lowPrice = productListViewEntity.getLowPrice();
        this.category1 = productListViewEntity.getCategory1();
        this.category2 = productListViewEntity.getCategory2();
        this.category3 = productListViewEntity.getCategory3();
        this.userId = productListViewEntity.getUserId();
        this.writeDatetime = productListViewEntity.getWriteDatetime();
    }

    public static List<ProductListItem> getList(List<ProductListViewEntity> productListViewEntities) {
        List<ProductListItem> list = new ArrayList<>();
        for (ProductListViewEntity boardListViewEntity : productListViewEntities) {
            list.add(new ProductListItem(boardListViewEntity));
        }
        return list;
    }
}
