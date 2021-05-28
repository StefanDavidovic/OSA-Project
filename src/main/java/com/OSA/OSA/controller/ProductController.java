package com.OSA.OSA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OSA.OSA.model.DTO.ProductDTO;
import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.service.ProductService;


@RestController
@RequestMapping(value = "api/articles")
public class ProductController {
	
    @Autowired
    private ProductService productService;

    
    
    @GetMapping
    public ResponseEntity<List<ProductDTO>> getProducts() {
        List<Product> products = productService.findAll();
        System.out.println("BLAA");

        // Convert products to DTOs
        List<ProductDTO> productsDTO = new ArrayList<>();
        for (Product p : products) {
            productsDTO.add(new ProductDTO(p));
        }

        return new ResponseEntity<>(productsDTO, HttpStatus.OK);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable("id") Integer id) {
        Product product = productService.findOne(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
    }
    
    @PostMapping(consumes = "application/json")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage_src(productDTO.getImage_src());

        product = productService.save(product);
        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.CREATED);
    }
    
    @PutMapping(value = "/{id}", consumes = "application/json")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductDTO productDTO, @PathVariable("id") Integer id) {
        // A product must exist
        Product product = productService.findOne(id);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        product.setName(productDTO.getName());
        product.setDescription(productDTO.getDescription());
        product.setPrice(productDTO.getPrice());
        product.setImage_src(productDTO.getImage_src());


        product = productService.save(product);

        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        Product product = productService.findOne(id);
        if (product != null) {
            productService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    

}
