package com.salbin.cart.CartServices;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salbin.cart.Entity.Cart;
import com.salbin.cart.Repository.CartRepository;

@Service
public class CartService {

	@Autowired
	CartRepository cartRepository;

	public List<Cart> getAllCartItems() {
		List<Cart> carts = cartRepository.findAll();

		return carts;
	}

	public String addCartItems() {
		for (long i = 1; i < 4; i++) {
			System.out.println("" + i + " ::Integer parseInt(" + i * 2);
			cartRepository.save(new Cart(i, i, Integer.parseInt("" + i * 2)));
		}
		return "cart items added successfully";
	}

}
