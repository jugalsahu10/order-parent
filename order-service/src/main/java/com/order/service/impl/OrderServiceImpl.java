package com.order.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.Order;
import com.order.entity.vo.OrderVo;
import com.order.repository.OrderRepository;
import com.order.service.OrderService;
import com.order.service.Utils;

@Service
public class OrderServiceImpl implements OrderService {

	private Logger log = Logger.getLogger(OrderServiceImpl.class.getName());
	
	@Autowired
	private OrderRepository orderRepository;

	@Transactional
	public void save(Order order) {
		// TODO Auto-generated method stub
		log.debug("saving order");
		this.orderRepository.save(order);
	}

	@Transactional
	public void delete(Order order) {
		// TODO Auto-generated method stub
		this.orderRepository.delete(order);
	}

	@Transactional(readOnly = true)
	public OrderVo getOrderByIdLazy(Integer id) {
		// TODO Auto-generated method stub
		return Utils.OrderToOrderVoLazy(this.orderRepository.findOne(id));
	}

	@Transactional(readOnly = true)
	public List<OrderVo> getAllOrdersLazy() {
		// TODO Auto-generated method stub
		return Utils.OrderListToOrderVoListLazy(this.orderRepository.findAll());
	}

	@Transactional(readOnly = true)
	public OrderVo getOrderById(Integer id) {
		// TODO Auto-generated method stub
		return Utils.OrderToOrderVo(this.orderRepository.getOrderByIdEager(id));
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<OrderVo> getAllOrders() {
		// TODO Auto-generated method stub
		return Utils.OrderListToOrderVoList(this.orderRepository.getAllOrdersEager());
	}

}
