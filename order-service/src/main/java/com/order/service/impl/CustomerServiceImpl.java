package com.order.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.Customer;
import com.order.repository.CustomerRepository;
import com.order.service.CustomerService;
import com.order.service.Utils;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		this.customerRepository.save(customer);
	}

	@Transactional
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		this.customerRepository.delete(customer);
	}

	@Transactional(readOnly = true)
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		return this.customerRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return this.customerRepository.findAll();
	}

}
