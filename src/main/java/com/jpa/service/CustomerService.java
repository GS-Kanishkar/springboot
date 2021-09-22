package com.jpa.service;


import java.util.List;
import com.jpa.entities.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomer();
	public Customer addCustomer(Customer cust);
	public  Customer updateCustomer( Customer cust);
	public void deleteCustomerById(int id);
	public List<Customer> getByTransaction(double amount);

}