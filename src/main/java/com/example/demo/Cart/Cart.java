package com.example.demo.Cart;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Cart {
	
	@Id
	@GeneratedValue
	private Long cartId;
	private float totalValue;
	boolean isActive;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date created;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date updated = new Date();
	
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
	
	

	public Cart() {
		
	}
	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public float getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(float totalValue) {
		this.totalValue = totalValue;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	
	

}
