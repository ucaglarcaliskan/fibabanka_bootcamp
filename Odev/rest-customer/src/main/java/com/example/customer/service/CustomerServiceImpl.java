package com.example.customer.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.customer.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Override
	public Customer find(long customerId) {
		Customer customer = new Customer(customerId, "Uğur Çağlar Çalışkan", 100);
		return customer;
	}

	@Override
	public List<Customer> findAll() {
		List<Customer> customerList = new ArrayList<>();
		customerList.add(new Customer(101, "Uğur Çağlar Çalışkan", 100));
		customerList.add(new Customer(102, "Muhittin", 250));
		return customerList;
	}

	@Override
	public void createCustomer(Customer customer) {
		System.out.println("Müşteri eklendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " "
				+ customer.getTotalDebit());
	}

	@Override
	public void updateCustomer(Customer customer) {
		System.out.println("Müşteri güncellendi " + customer.getCustomerId() + " " + customer.getCustomerName() + " "
				+ customer.getTotalDebit());
	}

	@Override
	public void deleteCustomer(long customerId) {
		System.out.println("Müşteri silindi " + customerId);
	}

}
