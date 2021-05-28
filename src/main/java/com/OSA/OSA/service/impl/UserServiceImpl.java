package com.OSA.OSA.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.OSA.OSA.model.entity.User;
import com.OSA.OSA.repository.UserRepo;
import com.OSA.OSA.service.UserService;

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

}
