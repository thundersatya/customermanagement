package com.rameshsatya.peerprogramming.springbboot.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.rameshsatya.peerprogramming.springbboot.SpringbbootApplication;
import com.rameshsatya.peerprogramming.springbboot.model.Customer;

@SpringBootTest(classes = SpringbbootApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class CustomerControllerTest {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	@Order(1)
	void create_customer_test() throws Exception {

		Customer customer = new Customer();
		customer.setFirstName("Satya");
		customer.setLastName("Kadali");
		customer.setDob("12ddddd");

		ResponseEntity<String> responseEntity = this.restTemplate
				.postForEntity("http://localhost:" + port + "/api/v1/customers", customer, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());

	}

	@Test
	@Order(2)
	void get_customer_by_customerid_test() {
		assertEquals("Satya", this.restTemplate
				.getForObject("http://localhost:" + port + "/api/v1/customers/1", Customer.class).getFirstName());

	}
	
	@Test
	@Order(3)
	void update_customer_firstname_by_customerid_test() {
		Customer customer = new Customer();
		customer.setFirstName("Satya_Updated");
		this.restTemplate
				.put("http://localhost:" + port + "/api/v1/customers/1", customer);
		assertEquals("Satya_Updated", this.restTemplate
				.getForObject("http://localhost:" + port + "/api/v1/customers/1", Customer.class).getFirstName());

	}
	

}
