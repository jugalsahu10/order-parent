package com.order.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.order.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

	@Query("select o from Order o left join fetch o.customer left join fetch o.products where o.orderId = ?1")
	public Order getOrderByIdEager(Integer id);

	@Query("select o from Order o left join fetch o.customer left join fetch o.products")
	public List<Order> getAllOrdersEager();
}
