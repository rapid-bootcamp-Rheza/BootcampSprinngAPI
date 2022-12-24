package com.rapidtech.restapi.service;

import com.rapidtech.restapi.model.CustomerModel;
import com.rapidtech.restapi.model.ProductModel;

import java.util.List;
import java.util.Optional;

public interface CustomerService {
    List<CustomerModel> getAll();
    Optional<CustomerModel> getById(Long id);
    Optional<CustomerModel> save(CustomerModel model);
    Optional<CustomerModel> update(Long id,CustomerModel model);
    Optional<CustomerModel> delete(Long id);
}
