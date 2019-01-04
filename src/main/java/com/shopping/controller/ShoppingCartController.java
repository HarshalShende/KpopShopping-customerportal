package com.shopping.controller;



import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.shopping.domain.CD;
import com.shopping.domain.CartItem;
import com.shopping.domain.ShoppingCart;
import com.shopping.domain.User;
import com.shopping.service.CDService;
import com.shopping.service.CartItemService;
import com.shopping.service.ShoppingCartService;
import com.shopping.service.UserService;


@Controller
@RequestMapping("/shoppingCart")
public class ShoppingCartController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CartItemService cartItemService;
	
	@Autowired
	private ShoppingCartService shoppingCartService;
	
	@Autowired
	private CDService cdService;
	
	@RequestMapping("/cart")
	public String shoppingCart(Model model, Principal principal) {
		User user = userService.findByUsername(principal.getName());
		ShoppingCart shoppingCart = user.getShoppingCart();
		
		List<CartItem> cartItemList = cartItemService.findByShoppingCart(shoppingCart);
		
		shoppingCartService.updateShoppingCart(shoppingCart);
		
		model.addAttribute("cartItemList", cartItemList);
		model.addAttribute("shoppingCart", shoppingCart);
		
		return "shoppingCart";
	}
	
	
	@RequestMapping("/addItem")
	public String addItem(
			@ModelAttribute("cd") CD cd,
			@ModelAttribute("qty") String qty,
			Model model, Principal principal
			) {
		User user = userService.findByUsername(principal.getName());
		cd = cdService.findOne(cd.getId());
		
	/*	if (Integer.parseInt(qty) > cd.getInStockNumber()) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/cdDetail?id="+cd.getId();
		}
		*/
		
		if (!cartItemService.isEnoughStock(cd, user, Integer.parseInt(qty))) {
			model.addAttribute("notEnoughStock", true);
			return "forward:/cdDetail?id="+cd.getId();
		}

		CartItem cartItem = cartItemService.addCdToCartItem(cd, user, Integer.parseInt(qty));
		model.addAttribute("addCdSuccess", true);
		
		return "forward:/cdDetail?id="+cd.getId();
		
	}
	

}
