package com.example.demo.Product;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Product {
	
	@Id
	@GeneratedValue
	private long id;
	private String name;
	private float price;
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
    private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated = new Date();
	
	public Product() {
		
	}
	
	public Product(String name, float price) {
		this.name = name;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
	@PrePersist
	void onCreate()
	{
		created = updated = new Date();
	}
	
	@PreUpdate
	void onUpdate()
	{
		updated = new Date();
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

}
