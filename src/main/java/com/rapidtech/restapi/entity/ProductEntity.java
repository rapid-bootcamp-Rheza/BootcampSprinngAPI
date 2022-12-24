package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.ProductModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "product_tab")
@Entity
public class ProductEntity {
    @Id
    // id masih lanjutan belum terpisah
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @TableGenerator(name = "id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="product_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    private Long id;
    @Column(name = "product_code",length = 20,nullable = false)
    private String code;

    @Column(name = "product_name",length = 100,nullable = false)
    private String name;

    @Column(name = "product_price")
    private Double price;

    @Column(name = "category_id",nullable = false)
    private Long categoryId;
    @Column(name = "supplier_id", nullable = false)
    private Long supplierId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "category_Id",insertable = false, updatable = false)
    private CategoryEntity category;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id", insertable = false, updatable = false)
    private SupplierEntity supplier;

    @OneToMany(mappedBy = "product")
    private List<PurchaseOrderDetailEntity> purchaseOrderDetail = new ArrayList<>();


    public ProductEntity(ProductModel model){
        BeanUtils.copyProperties(model,this);
        /*
        Cara Manualnya
        this.code = model.getCode();
        this.name = model.getName();
        this.price = model.getPrice();
        this.categoryId = model.getCategoryId();
         */

    }
}
