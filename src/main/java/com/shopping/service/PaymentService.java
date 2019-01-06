package com.shopping.service;

import com.shopping.domain.Payment;
import com.shopping.domain.UserPayment;

public interface PaymentService {
	Payment setByUserPayment(UserPayment userPayment, Payment payment);
	
}
