package com.OSA.OSA.model.DTO;

import java.util.HashSet;
import java.util.Set;

import com.OSA.OSA.model.entity.Role;
import com.OSA.OSA.model.entity.User;

public class UserDTO {
	
	private Integer id;
	private String username;
	private String firstname;
	private String lastname;
	private String password;
	private boolean blocked;
    private Set<Role> roles = new HashSet<>();
	
	
	public UserDTO() {
		
	}
	
	public UserDTO(Integer id, String username, String firstname, String lastname, String password, boolean blocked) {
		this.id = id;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.blocked = blocked;
	}
	
    public UserDTO(User user) {
        this(user.getId(),user.getUsername(), user.getFirstname(),
        		user.getLastname(), user.getPassword(), user.isBlocked());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isBlocked() {
		return blocked;
	}

	public void setBlocked(boolean blocked) {
		this.blocked = blocked;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
    
    
	

}
