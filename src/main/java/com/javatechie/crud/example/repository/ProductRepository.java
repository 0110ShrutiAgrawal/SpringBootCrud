package com.javatechie.crud.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.javatechie.crud.example.entity.Product;

//here we specify model name and then the data type of primary key
public interface ProductRepository extends JpaRepository<Product,Integer> {

	Product findByName(String name);
//this class has the persistence logic and it is injected in service class
}
