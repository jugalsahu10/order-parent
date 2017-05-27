package com.order.service;

import java.util.List;

import com.order.entity.Order;
import com.order.entity.vo.OrderVo;

public interface OrderService {
	public void save(Order order);

	public void delete(Order order);

	public OrderVo getOrderById(Integer id);

	public List<OrderVo> getAllOrders();
	
	public OrderVo getOrderByIdLazy(Integer id);

	public List<OrderVo> getAllOrdersLazy();
}
