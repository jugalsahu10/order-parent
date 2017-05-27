package com.order.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.order.entity.Product;
import com.order.entity.vo.ProductVo;
import com.order.repository.ProductRepository;
import com.order.service.ProductService;
import com.order.service.Utils;

@Service
public class ProductServiceImpl implements ProductService {

	private Logger log = Logger.getLogger(ProductServiceImpl.class.getName());
	
	@Autowired
	private ProductRepository productRepository;

	@Transactional
	public void save(Product product) {
		// TODO Auto-generated method stub
		log.debug("saving product");
		this.productRepository.save(product);
	}

	@Transactional
	public void delete(Product product) {
		// TODO Auto-generated method stub
		this.productRepository.delete(product);
	}

	@Transactional(readOnly = true)
	public ProductVo getProductByIdLazy(Integer id) {
		// TODO Auto-generated method stub
		return Utils.ProductToProductVoLazy(this.productRepository.findOne(id));
	}

	@Transactional(readOnly = true)
	public List<ProductVo> getAllProductsLazy() {
		// TODO Auto-generated method stub
		return Utils.ProductListToProductVoListLazy(this.productRepository.findAll());
	}

	@Transactional(readOnly = true)
	public Product getProductById(Integer id) {
		// TODO Auto-generated method stub
		return this.productRepository.getProductByIdEager(id);
	}

	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	public List<ProductVo> getAllProducts() {
		// TODO Auto-generated method stub
		return Utils.ProductListToProductVoList(this.productRepository.getAllProductsEager());
	}

}
