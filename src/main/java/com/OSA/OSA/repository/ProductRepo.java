package com.OSA.OSA.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.OSA.OSA.model.entity.Product;



@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {
}
