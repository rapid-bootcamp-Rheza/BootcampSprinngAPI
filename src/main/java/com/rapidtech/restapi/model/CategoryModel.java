package com.rapidtech.restapi.model;

import com.rapidtech.restapi.entity.CategoryEntity;
import com.rapidtech.restapi.entity.CustomerEntity;
import com.rapidtech.restapi.entity.EmployeeEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryModel {
    private Long id;
    private String code;
    private String name;

    public  CategoryModel (CategoryEntity entity){
        BeanUtils.copyProperties(entity,this);
    }



}
