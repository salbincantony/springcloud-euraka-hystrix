package com.salbin.cart.Model;

public class CartListItem {
	private Long cartId;
	private Integer quantity;
	private Product product;
	

	public CartListItem() {
		super();
	}

	public CartListItem(Long cartId, Product product, Integer quantity) {
		super();
		this.cartId = cartId;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getCartId() {
		return cartId;
	}

	public void setCartId(Long cartId) {
		this.cartId = cartId;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
