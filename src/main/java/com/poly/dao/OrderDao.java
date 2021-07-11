package com.poly.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {
	
	@Query(value="select top 1 * from orders where username like ?1 order by id desc", nativeQuery = true)
	Order findTheTopId(String username);

}
