package com.cdac.springboothibernatedemo.repository;

import org.springframework.data.repository.CrudRepository;

import com.cdac.springboothibernatedemo.pojo.Product;

public interface ProductRepository extends CrudRepository
	<Product, Integer> {
	
}
