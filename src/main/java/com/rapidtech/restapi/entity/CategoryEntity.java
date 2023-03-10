package com.rapidtech.restapi.entity;

import com.rapidtech.restapi.model.CategoryModel;
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
@Entity
@Table(name = "category_tab")
public class CategoryEntity {
    @Id
    // id masih lanjutan belum terpisah
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @TableGenerator(name = "id_generator", table = "sequence_tab",
            pkColumnName = "gen_name", valueColumnName = "gen_value",
            pkColumnValue="category_id", initialValue=0, allocationSize=0)
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "id_generator")
    @Column(name = "id", length = 36)
    private Long id;

    @Column(name = "category_code", length = 20,nullable = false)
    private String code;

    @Column(name = "category_name", length = 100,nullable = false)
    private String name;

    @OneToMany(mappedBy = "category")
    private List<ProductEntity> products = new ArrayList<>();

    public CategoryEntity(CategoryModel model){
        BeanUtils.copyProperties(model,this);
    }
}
