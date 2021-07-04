package com.OSA.OSA.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.OSA.OSA.model.entity.Product;
import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.repository.UserRepo;
import com.OSA.OSA.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepository;

    @Override
    public User findByUsernameAndPassword(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user.getPassword().equals(password))
            return user;
        else
            return null;
    }

	@Override
	public void add(User user) {
		userRepository.save(user);
	}
	
    @Override
    public User findOne(Integer productId) {
        return userRepository.findById(productId).orElse(null);
    }

    @Override
    public List<User> findAll() {
    	System.out.println(userRepository.findAll());
        return userRepository.findAll();
    }
    
    @Override
    public void remove(Integer id) {
    	userRepository.deleteById(id);
    }


}
