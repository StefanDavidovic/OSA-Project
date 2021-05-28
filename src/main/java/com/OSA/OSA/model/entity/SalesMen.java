package com.OSA.OSA.model.entity;

import java.security.Identity;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "salesmen")
public class SalesMen{
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salesmen_id", unique = true, nullable = false)
	private Integer id;
	

	
    @Column(name = "adress", unique = true, nullable = false)
	private String adress;
    
    @Column(name = "beginDate", unique = true, nullable = false)
	private Date beginDate;
	
    @Column(name = "name", unique = true, nullable = false)
	private String name;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
	private User user;
    
    public SalesMen() {
    	
    }
    
    

	public SalesMen(String adress, Date beginDate, String name) {
		this.adress = adress;
		this.beginDate = beginDate;
		this.name = name;
	}
	
	


	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
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
