package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<Page<Product>> getProducts(@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "100") int size){ //el required es para que se pueda acceder directo desde /products y no tener que hacer si o si /products?page=0&size=100
		return new ResponseEntity<>(service.getProducts(page, size),HttpStatus.OK);
	}
	
	@GetMapping("/names")
	public ResponseEntity<Page<String>> getNames(@RequestParam(required = false, value = "page", defaultValue = "0") int page,
			@RequestParam(required = false, value = "size", defaultValue = "100") int size){ //devuelve todos los nombres
		return new ResponseEntity<>(service.getNames(page, size),HttpStatus.OK);
	}
	
	@GetMapping("/{productId}")
	public ResponseEntity<Product> getProductById(@PathVariable("productId") Integer productId){
		return new ResponseEntity<>(service.getProductById(productId),HttpStatus.OK);
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Product> getProductByName(@PathVariable("name") String name){
		return new ResponseEntity<>(service.getProductByName(name),HttpStatus.OK);
	}

}
