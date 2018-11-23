package com.example.demo.Accounts;

import com.example.demo.Cart.Cart;

import java.util.Date;

import javax.persistence.*;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long aid;
	private String name;
	private String address;
	private Long contact;
	private String email;
	@Column(unique=true, nullable=false)
	private String username;
	private String password;
	private String ques;
	private String ans;

	@JoinColumn(name="cartId")
	@OneToOne(cascade = CascadeType.PERSIST)
	private Cart cart;
	
	@Temporal(TemporalType.TIMESTAMP)
    private Date created;
	
	private Date updated = new Date();
	
	@PrePersist
    public void onCreate()
    {
        created = updated = new Date();
    }
	
	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Date getUpdated() {
		return updated;
	}

	public void setUpdated(Date updated) {
		this.updated = updated;
	}

	public Account() {
	}
	
	public Long getAid() {
		return aid;
	}
	public void setAid(Long aid) {
		this.aid = aid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getContact() {
		return contact;
	}
	public void setContact(Long contact) {
		this.contact = contact;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getQues() {
		return ques;
	}

	public void setQues(String ques) {
		this.ques = ques;
	}

	public String getAns() {
		return ans;
	}

	public void setAns(String ans) {
		this.ans = ans;
	}
	
	

}
