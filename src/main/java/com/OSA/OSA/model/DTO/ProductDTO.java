package com.OSA.OSA.model.DTO;

import java.math.BigDecimal;

import com.OSA.OSA.model.entity.Product;

public class ProductDTO {

    private Integer id;

    private String name;

    private String description;

    private BigDecimal price;
    
    private String image_src;
    
    public ProductDTO() {
    }

	public ProductDTO(Integer id, String name, String description, BigDecimal price, String image_src) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.image_src = image_src;
	}
	
    public ProductDTO(Product product) {
        this(product.getId(), product.getName(),
                product.getDescription(), product.getPrice(), product.getImage_src());
    }

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getImage_src() {
		return image_src;
	}

	public void setImage_src(String image_src) {
		this.image_src = image_src;
	}
    
    
}
