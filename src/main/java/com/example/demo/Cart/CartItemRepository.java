package com.example.demo.Cart;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CartItemRepository extends CrudRepository<CartItems, Long> {

    @Query(value ="select * from CART_ITEMS where CART_ID = ?1",nativeQuery = true)
    public List<CartItems> findAllByCartId(Long cartId);

}
