package com.ersen.entity.builder;

import com.ersen.entity.Customer;

public class CustomerBuilder {

	private Customer customer;

	public CustomerBuilder() {
		customer = new Customer();
	}

	public CustomerBuilder id(long id) {
		customer.setId(id);
		return this;
	}

	public Customer get() {
		return customer;
	}
}
