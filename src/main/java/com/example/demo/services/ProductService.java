package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired //Para que lo inyecte
	private ProductRepository repository;
	
	public List<Product> getProducts(){ //repositorio que devuelve todos los roles
		return repository.findAll();
	}

}
