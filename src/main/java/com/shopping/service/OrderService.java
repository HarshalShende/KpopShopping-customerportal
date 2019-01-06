package com.shopping.service;

import com.shopping.domain.BillingAddress;
import com.shopping.domain.Order;
import com.shopping.domain.Payment;
import com.shopping.domain.ShippingAddress;
import com.shopping.domain.ShoppingCart;
import com.shopping.domain.User;

public interface OrderService {
	Order createOrder(ShoppingCart shoppingCart, 
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user);
	
	Order findById(Long id);
}
