package com.shopping.service;


import java.util.List;

import com.shopping.domain.CartItem;
import com.shopping.domain.ShoppingCart;



public interface CartItemService {
	List<CartItem> findByShoppingCart(ShoppingCart shoppingCart);
	
	CartItem updateCartItem(CartItem cartItem);
}
