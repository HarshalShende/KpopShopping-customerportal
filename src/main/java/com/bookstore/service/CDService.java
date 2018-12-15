package com.bookstore.service;

import java.util.List;

import com.bookstore.domain.CD;

public interface CDService {
	List<CD> findAll();
	
	CD findOne(Long id);
}
