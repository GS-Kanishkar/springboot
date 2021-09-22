package com.jpa.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.entities.Customer;
import com.jpa.service.CustomerServiceImpl;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	@Autowired
	CustomerServiceImpl custService;
	
	@GetMapping
	public List<Customer> getAllCustomer(){
		return custService.getAllCustomer();
	}
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@RequestBody Customer cust) {
		return custService.addCustomer(cust);
	}
	@PutMapping
	public  Customer updateCustomer(@RequestBody Customer cust) {
		return custService.updateCustomer(cust);
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public void deleteCustomerById(int id) {
		custService.deleteCustomerById(id);
	}
	@GetMapping("cust/{amount}")
	public List<Customer> getByTransaction(@PathVariable("amount")double amount){
		return custService.getByTransaction(amount);
	}
}