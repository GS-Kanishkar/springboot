package com.jpa.service;

import java.util.List;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jpa.dao.CustomerRepository;
import com.jpa.entities.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{
    @Autowired
    private CustomerRepository repository;
	@Override
	public List<Customer> getAllCustomer() {
		return (List<Customer>)repository.findAll();
	}
	@Override
	public Customer addCustomer(Customer cust) {
		return repository.save(cust);
	}
	@Override
	public Customer updateCustomer(Customer cust) {
		Customer customer =repository.findById(cust.getCustId()).orElseThrow(
				() -> new EntityNotFoundException("no customer found by the id"));
		customer.setCustName(cust.getCustName());
		return repository.save(customer); 
	}
	@Override
	public void deleteCustomerById(int id) {
		repository.deleteById(id);
	}
	@Override
	public List<Customer> getByTransaction(double amount) {
		return (List<Customer>)repository.findByAmount(amount);
	}
}