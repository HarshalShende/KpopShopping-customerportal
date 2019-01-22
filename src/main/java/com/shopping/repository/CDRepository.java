package com.shopping.repository;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.shopping.domain.CD;

public interface CDRepository extends CrudRepository<CD, Long>{
	List<CD> findByCategory(String category);
	
	List<CD> findByTitleContaining(String title);
	
}
