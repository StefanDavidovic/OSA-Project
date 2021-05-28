package com.OSA.OSA.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.OSA.OSA.model.entity.Role;

public interface RoleRepository  extends JpaRepository<Role, Integer>{

	Optional<Role> findByName(String name);
	
}
