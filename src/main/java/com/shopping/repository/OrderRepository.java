package com.shopping.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopping.domain.Order;

public interface OrderRepository extends CrudRepository<Order, Long>{

	
}
