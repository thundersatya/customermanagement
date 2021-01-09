package com.rameshsatya.peerprogramming.springbboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rameshsatya.peerprogramming.springbboot.model.Customer;
import com.rameshsatya.peerprogramming.springbboot.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {
	
	@Autowired
	private CustomerService custService;
	
	@PostMapping(path="/customers", consumes="application/json", produces = "application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
		
		Customer createdCustomer = custService.createCustomer(customer);
		return new ResponseEntity<Customer>(createdCustomer, HttpStatus.CREATED);	
		
	}
	
	@GetMapping("/customers/{id}")	
	public Customer getCustomer(@PathVariable("id") Long customerId) {
		return custService.getCustomerById(customerId);
	}
	
	public Customer updateCustomer()
	{
		return null;
	}
	
}
