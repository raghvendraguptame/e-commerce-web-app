package com.example.demo.Cart;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.example.demo.Product.Product;

@Entity
public class CartItems {
	
	@Id
	@GeneratedValue
	private Long cartItemId;
	
	@ManyToOne
	@JoinColumn(name ="productId")
	private Product item;
	private float value;
	private int quantity=1;
	
	@ManyToOne
	@JoinColumn(name ="cartId")
	private Cart cart;
	
	public Long getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(Long cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Product getItem() {
		return item;
	}

	public void setItem(Product item) {
		this.item = item;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
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

}
