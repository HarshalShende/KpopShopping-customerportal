package com.shopping.service.impl;



import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.domain.CD;
import com.shopping.domain.CartItem;
import com.shopping.domain.CdToCartItem;
import com.shopping.domain.ShoppingCart;
import com.shopping.domain.User;
import com.shopping.repository.CartItemRepository;
import com.shopping.repository.CdToCartItemRepository;
import com.shopping.service.CartItemService;



@Service
public class CartItemServiceImpl implements CartItemService{
	
	@Autowired
	private CartItemRepository cartItemRepository;
	
	@Autowired
	private CdToCartItemRepository cdToCartItemRepository;
	
	public List<CartItem> findByShoppingCart(ShoppingCart shoppingCart) {
		return cartItemRepository.findByShoppingCart(shoppingCart);
	}
	
	public CartItem updateCartItem(CartItem cartItem) {
		BigDecimal bigDecimal = new BigDecimal(cartItem.getCd().getListPrice()).multiply(new BigDecimal(cartItem.getQty()));
		
		bigDecimal = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
		cartItem.setSubtotal(bigDecimal);
		
		cartItemRepository.save(cartItem);
		
		return cartItem;
	}
	
	public CartItem addCdToCartItem(CD cd, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem: cartItemList) {
			if (cd.getId() == cartItem.getCd().getId()) {
				cartItem.setQty(cartItem.getQty() + qty);
				cartItem.setSubtotal(new BigDecimal(cd.getListPrice()).multiply(new BigDecimal(cartItem.getQty())));
				cartItemRepository.save(cartItem);
				return cartItem;
			}
		}
		
		CartItem cartItem = new CartItem();
		cartItem.setShoppingCart(user.getShoppingCart());
		cartItem.setCd(cd);
		cartItem.setQty(qty);
		cartItem.setSubtotal(new BigDecimal(cd.getListPrice()).multiply(new BigDecimal(cartItem.getQty())));
		
		cartItem = cartItemRepository.save(cartItem);
		
		CdToCartItem cdToCartItem = new CdToCartItem();
		cdToCartItem.setCd(cd);
		cdToCartItem.setCartItem(cartItem);
		cdToCartItemRepository.save(cdToCartItem);
		
		return cartItem;
		
	}
	
	public 	boolean isEnoughStock(CD cd, User user, int qty) {
		List<CartItem> cartItemList = findByShoppingCart(user.getShoppingCart());
		
		for (CartItem cartItem: cartItemList) {
			if (cd.getId() == cartItem.getCd().getId()) {
				if (cartItem.getQty()+qty>cd.getInStockNumber()) return false;
				return true;
			}
		}
		
		if (qty>cd.getInStockNumber()) return false;
		return true;
	}

}
