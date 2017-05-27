package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.entity.Order;
import com.order.entity.vo.OrderVo;
import com.order.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;

	@RequestMapping(value = "order/save", method = RequestMethod.POST)
	public @ResponseBody void saveOrder(@RequestBody Order order) {
		this.orderService.save(order);
	}

	@RequestMapping(value = "order/delete", method = RequestMethod.DELETE)
	public @ResponseBody void deleteOrder(@RequestBody Order order) {
		this.orderService.delete(order);
	}

	@RequestMapping(value = "order/id", method = RequestMethod.POST)
	public @ResponseBody OrderVo getOrderById(@RequestBody Integer id) {
		return this.orderService.getOrderById(id);
	}

	@RequestMapping(value = "order/all", method = RequestMethod.GET)
	public @ResponseBody List<OrderVo> getAllOrders() {
		return this.orderService.getAllOrders();
	}

	@RequestMapping(value = "order/lazy/id", method = RequestMethod.POST)
	public @ResponseBody OrderVo getOrderByIdLazy(@RequestBody Integer id) {
		return this.orderService.getOrderByIdLazy(id);
	}

	@RequestMapping(value = "order/lazy/all", method = RequestMethod.GET)
	public @ResponseBody List<OrderVo> getAllOrdersLazy() {
		return this.orderService.getAllOrdersLazy();
	}
}
