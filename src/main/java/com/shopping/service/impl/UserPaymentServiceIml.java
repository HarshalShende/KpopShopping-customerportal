package com.shopping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.domain.UserPayment;
import com.shopping.repository.UserPaymentRepository;
import com.shopping.service.UserPaymentService;

@Service
public class UserPaymentServiceIml implements UserPaymentService{

		@Autowired
		private UserPaymentRepository userPaymentRepository;
		
		public UserPayment findById(Long id) {
			return userPaymentRepository.findById(id).orElse(null);
		}
}
