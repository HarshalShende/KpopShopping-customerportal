package com.shopping.service;

import java.util.List;

import com.shopping.domain.CD;

public interface CDService {
	List<CD> findAll();
	
	CD findOne(Long id);
	
	List<CD> findByCategory(String category);
}
