package com.shopping.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopping.domain.ShoppingCart;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, Long>{

}
