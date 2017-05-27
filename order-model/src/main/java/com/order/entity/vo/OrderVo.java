package com.order.entity.vo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class OrderVo {

	private Integer orderId;

	private Date orderDate;

	private Integer price;

	private CustomerVo customerVo;

	private Set<ProductVo> productVos = new HashSet<ProductVo>();

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public CustomerVo getCustomerVo() {
		return customerVo;
	}

	public void setCustomerVo(CustomerVo customerVo) {
		this.customerVo = customerVo;
	}

	public Set<ProductVo> getProductVos() {
		return productVos;
	}

	public void setProductVos(Set<ProductVo> productVos) {
		this.productVos = productVos;
	}

}
