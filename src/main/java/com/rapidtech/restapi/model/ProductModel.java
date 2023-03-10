package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductModel {
    private int id;
    private String name;
    private String code;
    private Double price;

    private Long categoryId;

    private String categoryName;

    private Long supplierId;

    private String supplierName;


    public ProductModel(ProductEntity entity){
//        this.id = entity.getId();
//        this.name = entity.getName();
//        this.price = entity.getPrice();
//        this.categoryName = entity.getCategory();
//        this.categoryId = entity.getCategoryId();
        BeanUtils.copyProperties(entity,this);
        if (entity.getCategory() != null){
            this.categoryName = entity.getCategory().getName();
        }
//        if (entity.getSupplier() != null){
//            this.supplierName = entity.getSupplier().getSupplierName();
//        }

    }

    public ProductModel(int id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
