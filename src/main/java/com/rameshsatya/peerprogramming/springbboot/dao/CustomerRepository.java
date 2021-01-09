package com.rameshsatya.peerprogramming.springbboot.dao;

import org.springframework.data.repository.CrudRepository;

import com.rameshsatya.peerprogramming.springbboot.entity.CustomerEntity;

public interface CustomerRepository extends CrudRepository<CustomerEntity, Long> {
	

}
