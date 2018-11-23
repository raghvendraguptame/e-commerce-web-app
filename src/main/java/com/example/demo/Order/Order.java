package com.example.demo.Order;

import com.example.demo.Cart.Cart;
import com.example.demo.Cart.CartItems;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Order {

    private Long orderId;
    private Date orderDate;
    private Cart cart;


}
