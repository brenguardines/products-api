package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Product;
import com.example.demo.services.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping
	public ResponseEntity<List<Product>> getProducts(){ //Lista con todos los productos
		return new ResponseEntity<List<Product>>(service.getProducts(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Product> createProducts(@RequestBody Product product){ //Para crear un producto
		return new ResponseEntity<Product>(service.createProduct(product), HttpStatus.CREATED);
	}
	
	@PutMapping("/{productId}")
	public ResponseEntity<Product> updateProducts(@PathVariable("productId")Integer productId, @RequestBody Product product){ //Para modificar un producto
		return new ResponseEntity<Product>(service.updateProduct(productId, product), HttpStatus.OK);
	}
	
	@DeleteMapping("/{productId}")
	public ResponseEntity<Void> deleteProduct(@PathVariable("productId")Integer productId){
		service.deleteProduct(productId);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}
}
