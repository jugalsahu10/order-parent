package com.order.entity.vo;

import java.util.HashSet;
import java.util.Set;

public class ProductVo {

	private Integer productId;

	private String productName;

	private Integer price;

	private String quantity;
	
	private Set<OrderVo> orderVos = new HashSet<OrderVo>();

	public Set<OrderVo> getOrderVos() {
		return orderVos;
	}

	public void setOrderVos(Set<OrderVo> orderVos) {
		this.orderVos = orderVos;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
