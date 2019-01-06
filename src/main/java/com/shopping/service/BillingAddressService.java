package com.shopping.service;

import com.shopping.domain.BillingAddress;
import com.shopping.domain.UserBilling;

public interface BillingAddressService {
	BillingAddress setByUserBilling(UserBilling userBilling, BillingAddress billingAddress);
}
