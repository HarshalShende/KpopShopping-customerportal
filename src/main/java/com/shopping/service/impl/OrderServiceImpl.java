package com.shopping.service.impl;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.domain.BillingAddress;
import com.shopping.domain.CD;
import com.shopping.domain.CartItem;
import com.shopping.domain.Order;
import com.shopping.domain.Payment;
import com.shopping.domain.ShippingAddress;
import com.shopping.domain.ShoppingCart;
import com.shopping.domain.User;
import com.shopping.repository.OrderRepository;
import com.shopping.service.CartItemService;
import com.shopping.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private CartItemService cartItemService;
	
	public Order createOrder(ShoppingCart shoppingCart, 
			ShippingAddress shippingAddress,
			BillingAddress billingAddress,
			Payment payment,
			String shippingMethod,
			User user) {
		Order order = new Order();
		order.setBillingAddress(billingAddress);
		order.setOrderStatus("created");
		order.setPayment(payment);
		order.setShippingAddress(shippingAddress);
		order.setShippingMethod(shippingMethod);
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		
		//update stock number of each item
		for(CartItem cartItem : cartItemList) {
			CD cd = cartItem.getCd();
			cartItem.setOrder(order);
			cd.setInStockNumber(cd.getInStockNumber() - cartItem.getQty());
		}
		
		order.setCartItemList(cartItemList);
		order.setOrderDate(Calendar.getInstance().getTime());
		order.setOrderTotal(shoppingCart.getGrandTotal());
		shippingAddress.setOrder(order);
		billingAddress.setOrder(order);
		payment.setOrder(order);
		order.setUser(user);
		order = orderRepository.save(order);
		
		return order;
	}
	
	public Order findById(Long id) {
		return orderRepository.findById(id).orElse(null);
	}
}
