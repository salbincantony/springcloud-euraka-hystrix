package com.salbin.cart.CartServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.salbin.cart.Entity.Cart;
import com.salbin.cart.Model.CartListItem;
import com.salbin.cart.Model.Product;

@Service
public class CatalogueInfo {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@HystrixCommand(fallbackMethod = "getFallbackCatalogueItem")
	public CartListItem getCatalogueItem(Cart cart) {
		Product product = restTemplate.getForObject("http://product-catalogue-service/product-service/catalogue/" + cart.getProductId(),
				Product.class);
		System.out.println(product.getId());
		return new CartListItem(cart.getCartId(), product, cart.getQuantity());
	}
	
	public CartListItem getFallbackCatalogueItem(Cart cart) {
		
		return new CartListItem(cart.getCartId(), new Product(0L, "No product available", "", 0, 0, ""), cart.getQuantity());
	}


}
