package com.shopping.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.shopping.domain.CartItem;
import com.shopping.domain.CdToCartItem;

@Transactional
public interface CdToCartItemRepository extends CrudRepository<CdToCartItem, Long>{

	void deleteByCartItem(CartItem cartItem);
	
}
