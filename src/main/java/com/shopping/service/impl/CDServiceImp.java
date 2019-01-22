package com.shopping.service.impl;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.domain.CD;
import com.shopping.repository.CDRepository;
import com.shopping.service.CDService;


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
	
	@Override
	public List<CD> findByCategory(String category) {
		List<CD> cdList = cdRepository.findByCategory(category);
		
		List<CD> activeCdList = new ArrayList<>();
		
		for (CD cd: cdList) {
			if (cd.isActive()) {
				activeCdList.add(cd);
			}
		}
		
		return activeCdList;
	}
}