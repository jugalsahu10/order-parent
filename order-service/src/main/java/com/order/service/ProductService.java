package com.order.service;

import java.util.List;
import java.util.Set;

import com.order.entity.Product;
import com.order.entity.vo.ProductVo;

public interface ProductService {
	public void save(Product product);

	public void delete(Product product);

	public Product getProductById(Integer id);

	public List<ProductVo> getAllProducts();
	
	public ProductVo getProductByIdLazy(Integer id);

	public List<ProductVo> getAllProductsLazy();
}
