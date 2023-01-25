package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	public  Optional<Product> findByName(String name);
	
	@Query("SELECT p.name FROM Product p") //Es JPQL 
	public Page<String> findNames(PageRequest pageRequest);
}
