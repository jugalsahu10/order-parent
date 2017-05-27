package com.order.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;

import com.order.entity.Order;
import com.order.entity.Product;
import com.order.entity.vo.OrderVo;
import com.order.entity.vo.ProductVo;

public class Utils {
	public static ProductVo ProductToProductVo(Product product) {
		ProductVo productVo = new ProductVo();
		try {
			BeanUtils.copyProperties(productVo, product);
			for (Order order : product.getOrders()) {
				OrderVo orderVo = new OrderVo();
				BeanUtils.copyProperties(orderVo, order);
				productVo.getOrderVos().add(orderVo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productVo;
	}
	
	public static ProductVo ProductToProductVoLazy(Product product) {
		ProductVo productVo = new ProductVo();
		try {
			BeanUtils.copyProperties(productVo, product);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productVo;
	}

	public static List<ProductVo> ProductListToProductVoList(List<Product> products) {
		List<ProductVo> productVos = new ArrayList<ProductVo>();
		try {
			for (Product product : products) {
				ProductVo productVo = new ProductVo();
				BeanUtils.copyProperties(productVo, product);
				for (Order order : product.getOrders()) {
					OrderVo orderVo = new OrderVo();
					BeanUtils.copyProperties(orderVo, order);
					productVo.getOrderVos().add(orderVo);
				}
				productVos.add(productVo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productVos;
	}
	
	public static List<ProductVo> ProductListToProductVoListLazy(List<Product> products) {
		List<ProductVo> productVos = new ArrayList<ProductVo>();
		try {
			for (Product product : products) {
				ProductVo productVo = new ProductVo();
				BeanUtils.copyProperties(productVo, product);
				productVos.add(productVo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return productVos;
	}

	public static OrderVo OrderToOrderVo(Order order) {
		OrderVo orderVo = new OrderVo();
		try {
			BeanUtils.copyProperties(orderVo, order);
			BeanUtils.copyProperties(orderVo.getCustomerVo(), order.getCustomer());
			for (Product product : order.getProducts()) {
				ProductVo productVo = new ProductVo();
				BeanUtils.copyProperties(productVo, product);
				orderVo.getProductVos().add(productVo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVo;
	}
	
	public static OrderVo OrderToOrderVoLazy(Order order) {
		OrderVo orderVo = new OrderVo();
		try {
			BeanUtils.copyProperties(orderVo, order);
			BeanUtils.copyProperties(orderVo.getCustomerVo(), order.getCustomer());
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVo;
	}

	public static List<OrderVo> OrderListToOrderVoList(List<Order> orders) {
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		try {
			for (Order order : orders) {
				OrderVo orderVo = new OrderVo();
				BeanUtils.copyProperties(orderVo, order);
				BeanUtils.copyProperties(orderVo.getCustomerVo(), order.getCustomer());
				for (Product product : order.getProducts()) {
					ProductVo productVo = new ProductVo();
					BeanUtils.copyProperties(productVo, product);
					orderVo.getProductVos().add(productVo);
				}
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVos;
	}
	
	public static List<OrderVo> OrderListToOrderVoListLazy(List<Order> orders) {
		List<OrderVo> orderVos = new ArrayList<OrderVo>();
		try {
			for (Order order : orders) {
				OrderVo orderVo = new OrderVo();
				BeanUtils.copyProperties(orderVo, order);
				orderVos.add(orderVo);
			}
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return orderVos;
	}
}
