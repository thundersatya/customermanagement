package com.rameshsatya.peerprogramming.springbboot.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rameshsatya.peerprogramming.springbboot.dao.CustomerRepository;
import com.rameshsatya.peerprogramming.springbboot.entity.CustomerEntity;
import com.rameshsatya.peerprogramming.springbboot.exception.CustomerNotFoundException;
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
		customer.setCustomerId(customerEntity.getCustomerId());
		return customer;
	}

	@Override
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException {
		  Optional<CustomerEntity> customerOptional = custRepo.findById(customerId);
		  Customer customer = new Customer();
		  ModelMapper mapper = new ModelMapper();
		  if(customerOptional.isPresent())
			  mapper.map(customerOptional.get(), customer); 
		  else
			  throw new CustomerNotFoundException("CUST404", "Customer Not Found CUST_ID: "+customerId);
		  return customer;
	}

	@Override	
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException{
		
		ModelMapper modelMapper = new ModelMapper();
		CustomerEntity customerEntity = new CustomerEntity();
		modelMapper.map(customer, customerEntity);
		
		custRepo.save(customerEntity);
		
		return customer;
	}


}
