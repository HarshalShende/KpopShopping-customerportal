package com.shopping;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shopping.domain.User;
import com.shopping.domain.security.Role;
import com.shopping.domain.security.UserRole;
import com.shopping.service.UserService;
import com.shopping.utility.SecurityUtility;

@SpringBootApplication
public class ShoppingApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		User user1 = new User();
		user1.setFirstName("Tian");
		user1.setLastName("Shi");
		user1.setUsername("ts");
		user1.setPassword(SecurityUtility.passwordEncoder().encode("p"));
		user1.setEmail("tianshi.st1020@gmail.com");
		Set<UserRole> userRoles = new HashSet<>();
		Role role1 = new Role();
		role1.setRoleId(1);
		role1.setName("ROLE_USER");
		userRoles.add(new UserRole(user1, role1));
		
		userService.createUser(user1, userRoles);
		
	}
}
