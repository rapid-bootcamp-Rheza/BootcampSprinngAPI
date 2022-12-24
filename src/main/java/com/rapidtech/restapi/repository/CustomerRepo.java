package com.rapidtech.restapi.repository;

import com.rapidtech.restapi.entity.CustomerEntity;
import com.rapidtech.restapi.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo  extends JpaRepository<CustomerEntity,Long> {
}
