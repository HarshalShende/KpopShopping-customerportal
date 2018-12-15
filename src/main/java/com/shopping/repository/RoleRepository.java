package com.shopping.repository;

import org.springframework.data.repository.CrudRepository;

import com.shopping.domain.security.Role;

public interface RoleRepository extends CrudRepository<Role, Long>{
	Role findByname(String name);
}
