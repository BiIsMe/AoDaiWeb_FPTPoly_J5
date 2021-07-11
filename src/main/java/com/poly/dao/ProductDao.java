package com.poly.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.poly.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

	@Query("select p from Product p where p.category.id like ?1")
	Page<Product> findByFilter(String id, Pageable pageable);
}
