package com.shopping.service;


import java.util.List;

import com.shopping.domain.CD;
import com.shopping.domain.CartItem;
import com.shopping.domain.ShoppingCart;
import com.shopping.domain.User;



public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
	
	CartItem addCdToCartItem(CD cd, User user, int qty);
	
	boolean isEnoughStock(CD cd, User user, int qty);
	
	CartItem findById(Long id);
	
	void removeCartItem(Long id);
}
