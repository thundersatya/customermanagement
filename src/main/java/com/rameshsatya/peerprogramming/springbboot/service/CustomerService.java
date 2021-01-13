package com.rameshsatya.peerprogramming.springbboot.service;

import com.rameshsatya.peerprogramming.springbboot.exception.CustomerNotFoundException;
import com.rameshsatya.peerprogramming.springbboot.model.Customer;

public interface CustomerService {
	
	public Customer createCustomer(Customer customer);
	public Customer getCustomerById(Long customerId) throws CustomerNotFoundException;
	public Customer updateCustomer(Customer customer) throws CustomerNotFoundException;

}
