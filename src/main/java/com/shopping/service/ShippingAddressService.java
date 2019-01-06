package com.shopping.service;

import com.shopping.domain.ShippingAddress;
import com.shopping.domain.UserShipping;

public interface ShippingAddressService {
	ShippingAddress setByUserShipping(UserShipping userShipping, ShippingAddress shippingAddress);
}
