package com.example.customer.service;

import java.util.List;

import com.example.customer.Customer;

public interface CustomerService {
	public Customer find(long customerId);

	public List<Customer> findAll();

	public void createCustomer(Customer customer);

	public void updateCustomer(Customer customer);

	public void deleteCustomer(long customerId);

}
