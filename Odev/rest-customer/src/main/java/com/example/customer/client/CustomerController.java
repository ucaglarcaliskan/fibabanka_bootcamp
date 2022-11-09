package com.example.customer.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.customer.Customer;

@Controller
public class CustomerController {

	@GetMapping("/customer/get")
	@ResponseBody
	public String getCustomer() {
		long customerId = 1;
		String url = "http://localhost:8080/api/customer/" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		Customer customer = restTemplate.getForObject(url, Customer.class);
		System.out.println("Müşteri: " + customer.getCustomerName());
		return "Edinme Başarılı " + customer.getCustomerName();
	}

	@GetMapping("/customer/post")
	@ResponseBody
	public String postCustomer() {
		Customer customer = new Customer(101, "Uğur Çağlar ÇALIŞKAN", 120);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		Customer result = restTemplate.postForObject(url, customer, Customer.class);
		return "Yollama başarılı " + result.getCustomerId();
	}

	@GetMapping("/customer/put")
	@ResponseBody
	public String putCustomer() {
		Customer customer = new Customer(101, "Uğur Çağlar ÇALIŞKAN", 200);
		String url = "http://localhost:8080/api/customer";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Customer>(customer), Void.class);
		return "Koyma Başarılı " + customer.getCustomerName();
	}

	@GetMapping("/customer/delete")
	@ResponseBody
	public String deleteEmployee() {
		long customerId = 102;
		String url = "http://localhost:8080/api/customer" + customerId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme başarılı " + customerId;
	}
}
