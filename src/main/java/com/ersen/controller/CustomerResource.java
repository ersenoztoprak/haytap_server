package com.ersen.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ersen.entity.Customer;
import com.ersen.repository.CustomerRepository;


@RestController
@RequestMapping(value = "/customer", produces = "application/json")
@Transactional
public class CustomerResource {

	
	private CustomerRepository customerRepository;
	
	@Autowired
	public CustomerResource (CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void createCustomer (@RequestBody(required = true) Customer customer) {
		customerRepository.save(customer);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Customer getCustomer (@PathVariable("id") Long id) {
		return customerRepository.getById(id);
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<Customer> getCustomers () {
		
		Iterable<Customer> it = customerRepository.findAll();
        Iterator<Customer> itr = it.iterator();
        
        List<Customer> list = new ArrayList<Customer>();
        while(itr.hasNext()) {
          Customer obj = (Customer)itr.next();
          list.add(obj);
        }
		
		return list;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public void deleteCustomer (@PathVariable("id") Long id) {
		customerRepository.deleteById(id);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public void updateCustomer (@PathVariable("id") long id, @RequestBody(required = true) Customer customer) {
		customerRepository.updateCustomer(id, customer.getAge(), customer.getName());
	}
	
}
