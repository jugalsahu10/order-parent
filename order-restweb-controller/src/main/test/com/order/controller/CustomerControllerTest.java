package com.order.controller;

import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.codehaus.jackson.map.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.order.entity.Customer;
import com.order.service.impl.CustomerServiceImpl;

import jdk.nashorn.internal.ir.annotations.Ignore;

public class CustomerControllerTest {

	MockMvc mockMvc;

	@InjectMocks
	private CustomerController customerController;

	@Mock
	private CustomerServiceImpl customerService;

	private final static Integer customerId = 1;

	private Customer customer;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(customerController).build();

		customer = new Customer();
	}

	@After
	public void teardown() {

	}

	@Test
	public void saveCustomer() throws Exception {
		this.mockMvc.perform(post("/customer/save").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customer))).andExpect(status().isOk());
		Mockito.verify(this.customerService).save(any(Customer.class));
	}

	@Test
	public void deleteCustomer() throws Exception {
		this.mockMvc.perform(delete("/customer/delete").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(customer))).andExpect(status().isOk());
		Mockito.verify(this.customerService).delete(any(Customer.class));
	}

	@Ignore
	@Test
	public void getCustomerById() throws Exception {
		this.mockMvc
				.perform(post("/customer/id").contentType(MediaType.APPLICATION_JSON)
						.content(new ObjectMapper().writeValueAsString(customerId)))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.data.roles.length").value(customerId));
		Mockito.verify(this.customerService).getCustomerById(customerId);
	}
}
