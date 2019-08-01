package com.demo.shoppingcart.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.shoppingcart.entity.Product;
import com.demo.shoppingcart.model.ProductList;
import com.demo.shoppingcart.service.ProductService;

@RestController
public class ProductResource {
	@Autowired
	ProductService productService;

	@GetMapping(value = "/catalogue")
	public ResponseEntity<ProductList> viewAllCatalogue() {

		return new ResponseEntity<ProductList> (productService.getProductList(),HttpStatus.OK);
	}

	@GetMapping(value = "/catalogue/{id}", produces = "application/json")
	public Product viewCatalogueById(@PathVariable(value = "id") Long productId) {

		return productService.getProductById(productId);
	}
}
