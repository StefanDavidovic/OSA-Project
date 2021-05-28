package com.OSA.OSA.model.DTO;

import java.io.Serializable;

public class BuyerDTO implements Serializable {
	
	private Integer id;
	private String adress;
	
	public BuyerDTO(Integer id, String adress) {
		this.id = id;
		this.adress = adress;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getAdress() {
		return adress;
	}
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	

}
