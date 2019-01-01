package com.shopping.service;

import com.shopping.domain.UserPayment;

public interface UserPaymentService {
	UserPayment findById(Long id);
	void removeById(Long id);
}
