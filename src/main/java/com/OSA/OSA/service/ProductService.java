package com.OSA.OSA.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.Product;



public interface ProductService {

    Product findOne(Integer productId);
    
    List<Product> findAll();

    Product save(Product product);

    void remove(Integer id);

}
