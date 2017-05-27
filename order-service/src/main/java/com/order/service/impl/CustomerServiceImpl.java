package com.order.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.Customer;
import com.order.repository.CustomerRepository;
import com.order.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	private Logger log = Logger.getLogger(CustomerServiceImpl.class.getName());
	
	@Autowired
	private CustomerRepository customerRepository;

	@Transactional
	public void save(Customer customer) {
		// TODO Auto-generated method stub
		log.debug("saving customer");
		this.customerRepository.save(customer);
	}

	@Transactional
	public void delete(Customer customer) {
		// TODO Auto-generated method stub
		log.debug("deleting customer");
		this.customerRepository.delete(customer);
	}

	@Transactional(readOnly = true)
	public Customer getCustomerById(Integer id) {
		// TODO Auto-generated method stub
		log.debug("find customer by id");
		return this.customerRepository.findOne(id);
	}

	@Transactional(readOnly = true)
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		log.debug("get all customers");
		return this.customerRepository.findAll();
	}

}
