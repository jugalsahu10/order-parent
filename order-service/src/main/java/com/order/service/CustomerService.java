package com.order.service;

import java.util.List;
import java.util.Set;

import com.order.entity.Customer;
import com.order.entity.vo.CustomerVo;

public interface CustomerService {
	public void save(Customer customer);

	public void delete(Customer customer);

	public Customer getCustomerById(Integer id);

	public List<Customer> getAllCustomers();
}
