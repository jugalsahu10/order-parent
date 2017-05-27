package com.order.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

	@Query("select p from Product p left join fetch p.orders where p.productId = ?1")
	public Product getProductByIdEager(Integer id);

	@Query("select p from Product p left join fetch p.orders")
	public List<Product> getAllProductsEager();
}
