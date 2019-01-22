package com.shopping.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.shopping.domain.CD;
import com.shopping.domain.User;
import com.shopping.service.CDService;
import com.shopping.service.UserService;

@Controller
public class SearchController {

	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CDService cdService;
	
	@RequestMapping("/searchByCategory")
	public String searchByCategory(
			@RequestParam("category") String category,
			Model model,
			Principal principal
			) {
		if (principal != null) {
			String username = principal.getName();
			User user = userService.findByUsername(username);
			model.addAttribute("user", user);
		}
		
		String classActiveCategory = "active"+category;
		classActiveCategory = classActiveCategory.replaceAll("\\s+", "");
		
		model.addAttribute(classActiveCategory, true);
		model.addAttribute("activeAll", false);
		
		List <CD> cdList = cdService.findByCategory(category);
		
		if (cdList.isEmpty()) {
			model.addAttribute("emptyList", true);
			return "cdShelf";
		}
		
		model.addAttribute("cdList", cdList);
		return "cdShelf";
		
	}
}
