package com.OSA.OSA.model.DTO;

import java.io.Serializable;
import java.sql.Date;

public class SalesMenDTO implements Serializable{
	
	private Integer id;
	private Date beginDate;
	private String adress;
	private String name;
	
	
	public SalesMenDTO(Integer id, Date beginDate, String adress, String name) {
		this.id = id;
		this.beginDate = beginDate;
		this.adress = adress;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getBeginDate() {
		return beginDate;
	}


	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
