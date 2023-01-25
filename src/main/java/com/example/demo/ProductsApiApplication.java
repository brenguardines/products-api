package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entities.Product;
import com.example.demo.repositories.ProductRepository;
import com.github.javafaker.Faker;

@SpringBootApplication
public class ProductsApiApplication implements ApplicationRunner{
	
	@Autowired
	private Faker faker;
	
	@Autowired
	private ProductRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProductsApiApplication.class, args);
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception{
		for(int i = 0; i < 1000; i++) {
			Product product = new Product();
			product.setName(faker.commerce().productName());
			product.setImageUrl(null);
			product.setPrice((faker.random().nextDouble() * (10000)));
			repository.save(product);
		}
	}

}
