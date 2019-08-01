package com.salbin.cart.CartResource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.salbin.cart.CartServices.CartService;
import com.salbin.cart.CartServices.CatalogueInfo;
import com.salbin.cart.Entity.Cart;
import com.salbin.cart.Model.CartList;
import com.salbin.cart.Model.CartListItem;

@RestController
public class CartController {
	@Autowired
	CartService cartService;
	
	@Autowired
	CatalogueInfo catalogueInfo;
	
	@Autowired
	private RestTemplate restTemplate;

	@PostMapping(value = "/cart")
	public String addCartItems() {
		return cartService.addCartItems();
	}

	@GetMapping("/cart")
	public CartList getAllCartItems() {

		CartList cartList = new CartList();
		List<CartListItem> cartListItems = new ArrayList<CartListItem>();
		
		for (Cart cart : cartService.getAllCartItems()) {
			cartListItems.add(catalogueInfo.getCatalogueItem(cart));
		}
		cartList.setCartItems(cartListItems);
		return cartList;
	}
	
	public CartList getFallbackCatalogue() {
		
		return new CartList();
	}
	
	
}

/*
 * Alternative WebClient way Movie movie =
 * webClientBuilder.build().get().uri("http://localhost:8082/movies/"+
 * rating.getMovieId()) .retrieve().bodyToMono(Movie.class).block();
 */
