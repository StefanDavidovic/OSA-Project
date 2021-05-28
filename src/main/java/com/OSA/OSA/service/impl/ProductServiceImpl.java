package com.OSA.OSA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.repository.ProductRepo;
import com.OSA.OSA.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepo productRepository;

    @Override
    public Product findOne(Integer productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public List<Product> findAll() {
    	System.out.println(productRepository.findAll());
        return productRepository.findAll();
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
}
