package com.bookstore.service.impl;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.domain.CD;

import com.bookstore.repository.CDRepository;
import com.bookstore.service.CDService;


@Service
public class CDServiceImp implements CDService{
	
	@Autowired
	private CDRepository cdRepository;
	
	public List<CD> findAll(){
		return (List<CD>)cdRepository.findAll();
	}

	public CD findOne(Long id) {
		return cdRepository.findById(id).orElse(null);
	}
}