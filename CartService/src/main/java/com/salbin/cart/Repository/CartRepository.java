package com.salbin.cart.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salbin.cart.Entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

	
	
}
