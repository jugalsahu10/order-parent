package com.order.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	private Integer productId;

	private String productName;

	private Integer price;

	private String quantity;
	
	private Set<Order> orders = new HashSet<Order>();

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "product_id")
	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	@Column(name = "product_name")
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	@Column(name = "price")
	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
	
	@Column(name = "quantity")
	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	@ManyToMany(mappedBy = "products", fetch = FetchType.LAZY)
	public Set<Order> getOrders() {
		return orders;
	}

	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}

}
