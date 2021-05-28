package com.OSA.OSA.model.DTO;

import java.io.Serializable;

public class AdminDTO implements Serializable {
	
	private Integer id;
	
	

	public AdminDTO(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

}
