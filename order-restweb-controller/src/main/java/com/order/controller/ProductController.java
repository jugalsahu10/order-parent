package com.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.order.entity.Product;
import com.order.entity.vo.ProductVo;
import com.order.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "product/save", method = RequestMethod.POST)
	public @ResponseBody void saveProduct(@RequestBody Product product) {
		this.productService.save(product);
	}

	@RequestMapping(value = "product/delete", method = RequestMethod.DELETE)
	public @ResponseBody void deleteProduct(@RequestBody Product product) {
		this.productService.delete(product);
	}

	@RequestMapping(value = "product/id", method = RequestMethod.POST)
	public @ResponseBody Product getProductById(@RequestBody Integer id) {
		return this.productService.getProductById(id);
	}

	@RequestMapping(value = "product/all", method = RequestMethod.GET)
	public @ResponseBody List<ProductVo> getAllProducts() {
		return this.productService.getAllProducts();
	}
	
	@RequestMapping(value = "product/lazy/id", method = RequestMethod.POST)
	public @ResponseBody ProductVo getProductByIdLazy(@RequestBody Integer id) {
		return this.productService.getProductByIdLazy(id);
	}

	@RequestMapping(value = "product/lazy/all", method = RequestMethod.GET)
	public @ResponseBody List<ProductVo> getAllProductsLazy() {
		return this.productService.getAllProductsLazy();
	}
}
