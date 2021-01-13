package com.rameshsatya.peerprogramming.springbboot;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rameshsatya.peerprogramming.springbboot.exception.CustomerNotFoundException;
import com.rameshsatya.peerprogramming.springbboot.model.Customer;
import com.rameshsatya.peerprogramming.springbboot.service.CustomerService;

@RestController
@RequestMapping("/api/v1")
public class CustomerController {

	@Autowired
	private CustomerService custService;

	@PostMapping(path = "/customers", consumes = "application/json", produces = "application/json")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {

		Customer createdCustomer = custService.createCustomer(customer);
		return new ResponseEntity<>(createdCustomer, HttpStatus.CREATED);

	}

	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable("id") Long customerId) throws CustomerNotFoundException {
		return custService.getCustomerById(customerId);
	}

	@PutMapping("/customers/{id}")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer, @PathVariable Long id)
			throws CustomerNotFoundException {
			
			Customer newCustomer = custService.getCustomerById(id);	
			newCustomer.setFirstName(customer.getFirstName());
			newCustomer.setLastName(customer.getLastName());

			custService.updateCustomer(newCustomer);
			
			return new ResponseEntity<>("Customer Details Updated Successfully", HttpStatus.OK);
	}

	
}
