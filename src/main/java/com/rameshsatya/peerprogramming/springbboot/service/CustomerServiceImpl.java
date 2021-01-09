package com.rameshsatya.peerprogramming.springbboot.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rameshsatya.peerprogramming.springbboot.dao.CustomerRepository;
import com.rameshsatya.peerprogramming.springbboot.entity.CustomerEntity;
import com.rameshsatya.peerprogramming.springbboot.model.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	
	@Autowired
	private CustomerRepository custRepo;
	
	@Override
	public Customer createCustomer(Customer customer) {
		
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = new CustomerEntity();
		modelMapper.map(customer, customerEntity);
		
		custRepo.save(customerEntity);
		
		return customer;
	}

	
	  @Override 
	  public Customer getCustomerById(Long customerId) {
	  Optional<CustomerEntity> customerOptional = custRepo.findById(customerId);
	  Customer customer = new Customer();
	  ModelMapper mapper = new ModelMapper();
	  if(customerOptional.isPresent())
		  mapper.map(customerOptional.get(), customer); 
	  return customer;
	  }
	 
	
	

}
