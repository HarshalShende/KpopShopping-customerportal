package com.shopping.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopping.domain.CartItem;
import com.shopping.domain.ShoppingCart;

public interface CartItemRepository extends CrudRepository<CartItem, Long>{
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
}
