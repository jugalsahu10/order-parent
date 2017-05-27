package com.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.order.entity.Customer;
import com.order.repository.CustomerRepository;

public class CustomerServiceImplTest {
	
	@InjectMocks
	private CustomerServiceImpl customerService;
	
	@Mock
	private CustomerRepository customerRepository;

	private Customer customer;
	private List<Customer> customers;
	private Integer customerId = 1;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);

		customer = new Customer();
		customer.setCustomerId(customerId);

		customers = new ArrayList<Customer>();
		customers.add(customer);

		Mockito.when(this.customerRepository.findOne(customerId)).thenReturn(customer);
		Mockito.when(this.customerRepository.findAll()).thenReturn(customers);
	}

	@After
	public void teardown() {

	}

	@Test
	public void getCustomerByIdTest() {
		Customer expected = this.customerService.getCustomerById(customerId);
		Assert.assertEquals(expected.getCustomerId(), customerId);
		Mockito.verify(this.customerRepository).findOne(customerId);
	}

	@Test
	public void getAllCustomersTest() {
		List<Customer> expected = this.customerService.getAllCustomers();
		Assert.assertEquals(expected.get(0).getCustomerId(), customerId);
		Mockito.verify(this.customerRepository).findAll();
	}

	@Test
	public void saveTest() {
		this.customerService.save(customer);
		Mockito.verify(this.customerRepository).save(customer);
	}

	@Test
	public void deleteTest() {
		this.customerService.delete(customer);
		Mockito.verify(this.customerRepository).delete(customer);
	}
}
