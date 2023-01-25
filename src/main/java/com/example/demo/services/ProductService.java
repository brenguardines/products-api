package com.example.demo.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired //Para que lo inyecte
	private ProductRepository productRepository;
	
	public Page<Product> getProducts(int page, int size){ //page: numero de pagina y size: tamaño de pagina
		 return productRepository.findAll(PageRequest.of(page, size));
	}
	
	public Page<String> getNames(int page, int size){
		return productRepository.findNames(PageRequest.of(page, size));
	}
	
	public Product getProductById(Integer productId) {
		return productRepository.findById(productId).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,String.format("Product %d not found", productId)));		        
	}
	
	public Product getProductByName(String name) {
		return productRepository.findByName(name).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND ,String.format("Product %d not found", name)));
	}

}