package com.OSA.OSA.repository;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.OSA.OSA.model.DTO.UserDTO;
import com.OSA.OSA.model.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	
	@Query(value = "SELECT u FROM User u WHERE u.username = :username")
	User getUserByUsername(@Param("username") String username);

	
	User findByUsername(String username);
	
	Boolean existsByUsername(String username);

}
