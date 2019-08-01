package com.demo.shoppingcart.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.demo.shoppingcart.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Long> {
	 List<Product> findByName(String name);
}
