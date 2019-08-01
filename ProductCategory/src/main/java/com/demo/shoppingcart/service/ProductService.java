package com.demo.shoppingcart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.shoppingcart.entity.Product;
import com.demo.shoppingcart.model.ProductDTO;
import com.demo.shoppingcart.model.ProductList;
import com.demo.shoppingcart.model.ProductRepository;

@Service
public class ProductService {
	@Autowired
	ProductRepository productRepository;

	public ProductList getProductList() {
		// TODO: Make Mapper class for DTO mapping 
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		ProductDTO productDTO = null;
		ProductList productList =new ProductList();
		
		productRepository.save(new Product((long) 0, "iPhone 7","Mobile",60000, 20, "images/mobile/iphone7.jpg"));
		productRepository.save(new Product((long) 0, "redmi 7","Mobile",15000, 10, "images/mobile/redmi.jpg"));
		productRepository.save(new Product((long) 0, "Lenovo Thinkpad","Lenovo",60000, 20, "images/mobile/lenovo.jpg"));
		productRepository.save(new Product((long) 0, "Lenovo Thinkpad","Lenovo",60000, 20, "images/mobile/lenovo.jpg"));
		// TODO: Make Mapper class for DTO mapping 
		for (Product product : productRepository.findAll()) {
			productDTO =new ProductDTO();
			productDTO.setId(product.getId());
			productDTO.setName(product.getName());
			productDTO.setCategory(product.getCategory());
			productDTO.setImage(product.getImage());
			productDTO.setPrice(product.getPrice());
			productDTO.setQuantity(product.getQuantity());
		
			products.add(productDTO);
		}
		productList.setProducts(products);
		return productList;
	}

	public Product getProductById(Long id) {
		Product product;
		
		product = productRepository.findById(id).orElseGet(null);
		 return product;
	}

}
