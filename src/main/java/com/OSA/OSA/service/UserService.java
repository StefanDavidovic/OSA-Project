package com.OSA.OSA.service;

import com.OSA.OSA.model.entity.User;

public interface UserService {
	
    User findByUsernameAndPassword(String username, String password);

    void add(User user);

}
