package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.entity.Customer;
import com.order.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@RequestMapping(value = "customer/save", method = RequestMethod.POST)
	public @ResponseBody void saveCustomer(@RequestBody Customer customer) {
		this.customerService.save(customer);
	}

	@RequestMapping(value = "customer/delete", method = RequestMethod.DELETE)
	public @ResponseBody void deleteCustomer(@RequestBody Customer customer) {
		this.customerService.delete(customer);
	}

	@RequestMapping(value = "customer/id", method = RequestMethod.POST)
	public @ResponseBody Customer getCustomerById(@RequestBody Integer id) {
		return this.customerService.getCustomerById(id);
	}

	@RequestMapping(value = "customer/all", method = RequestMethod.GET)
	public @ResponseBody List<Customer> getAllCustomers() {
		return this.customerService.getAllCustomers();
	}

}
