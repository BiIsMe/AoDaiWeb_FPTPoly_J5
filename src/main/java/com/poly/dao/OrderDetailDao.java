package com.poly.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Orderdetail;

public interface OrderDetailDao extends JpaRepository<Orderdetail, Integer> {

	@Query("select o from Orderdetail o where o.order.id like ?1" )
	List<Orderdetail> findByIdOrder(int id);
	
	@Query(value="select sum(price*quantity) from orderdetails where orderid like ?1",nativeQuery = true)
	Long sumTotalPrice(int id);
	
	
}
