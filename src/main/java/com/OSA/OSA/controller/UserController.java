package com.OSA.OSA.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.OSA.OSA.model.DTO.UserDTO;
import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.service.UserService;

@RestController
@CrossOrigin(origins="http://localhost:3000")
@RequestMapping(value = "api/users")
public class UserController {
	
    @Autowired
    private UserService userService;
    
    @GetMapping
    public ResponseEntity<List<UserDTO>> getProducts() {
        List<User> users = userService.findAll();
        System.out.println("BLAA");

        // Convert products to DTOs
        List<UserDTO> userDTO = new ArrayList<>();
        for (User p : users) {
        	userDTO.add(new UserDTO(p));
        }

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
    
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserDTO> getProduct(@PathVariable("id") Integer id) {
        User product = userService.findOne(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UserDTO(product), HttpStatus.OK);
    }
    
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
        User product = userService.findOne(id);
        if (product != null) {
        	userService.remove(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
