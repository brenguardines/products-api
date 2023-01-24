package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired //Para que lo inyecte
	private ProductRepository repository;
	
	public List<Product> getProducts(){ //repositorio que devuelve todos los roles
		return repository.findAll();
	}
	
	public Product createProduct(Product product) {
		return repository.save(product);
	}
	
	public Product updateProduct(Integer productId, Product product) {
		Optional<Product> result = repository.findById(productId);
		if(result.isPresent()) {
			Product savedProduct = result.get();
			savedProduct.setName(product.getName());
			savedProduct.setPrice(product.getPrice());
			return repository.save(savedProduct);
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product id %d doesn't exists", productId));
		}
	}

	public void deleteProduct(Integer productId) {
		Optional<Product> result = repository.findById(productId);
		
		if(result.isPresent()) {
			repository.delete(result.get());
		}else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Product id %d doesn't exists", productId));
		}
		
	}

}
