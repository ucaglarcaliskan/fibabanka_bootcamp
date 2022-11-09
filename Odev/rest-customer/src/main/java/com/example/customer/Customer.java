package com.example.customer;

public class Customer {

	private long customerId;
	private String customerName;
	private double totalDebit;

	public Customer() {
	}

	public Customer(long customerId, String customerName, double totalDebit) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.totalDebit = totalDebit;
	}

	public long getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public double getTotalDebit() {
		return totalDebit;
	}

	public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setTotalDebit(double totalDebit) {
		this.totalDebit = totalDebit;
	}

}
