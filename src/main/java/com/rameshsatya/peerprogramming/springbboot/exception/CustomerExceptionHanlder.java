package com.rameshsatya.peerprogramming.springbboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerExceptionHanlder {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CustomerExceptionRes> handleGenericException(Exception exception)
	{
		CustomerExceptionRes custException = new CustomerExceptionRes("CUST500", "Error Occured While Processing Request!");
		 return new ResponseEntity<CustomerExceptionRes>(custException, HttpStatus.EXPECTATION_FAILED);
		
	}
	
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<CustomerExceptionRes> handleCustomerNotFoundException(CustomerNotFoundException exception)
	{
		CustomerExceptionRes custException = new CustomerExceptionRes(exception.getErrorCode(), exception.getErrorMessage());
		 return new ResponseEntity<CustomerExceptionRes>(custException, HttpStatus.NOT_FOUND);
		
	}

}
