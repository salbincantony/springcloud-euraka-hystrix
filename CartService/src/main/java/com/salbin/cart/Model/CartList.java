package com.salbin.cart.Model;

import java.util.List;

public class CartList {
	List<CartListItem> cartItems;

	
	public CartList() {
		super();
	}

	public CartList(List<CartListItem> cartItems) {
		super();
		this.cartItems = cartItems;
	}

	public List<CartListItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartListItem> cartItems) {
		this.cartItems = cartItems;
	}
	
}
