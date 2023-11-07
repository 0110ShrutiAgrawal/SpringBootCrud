package com.javatechie.crud.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.crud.example.entity.Product;
import com.javatechie.crud.example.repository.ProductRepository;

@Service
public class ProductService {
    //this class has the business logic
	//it interacts with entity class and database
	@Autowired
	//post methods
	ProductRepository repository;
	
	public Product saveProduct(Product product)
	{
		return repository.save(product);
	}
	public List <Product> saveProducts(List <Product> products)
	{
		return repository.saveAll(products);
	}
	//get method-to fetch object from database
	public List <Product> getProducts()
	{
		return repository.findAll();
	}
	public Product getProductById(int id)
	{
	    return repository.findById(id).orElse(null);
	}
	public Product getProductByName(String name)
	{
	    return repository.findByName(name);
	}
	
	//put methods
	public String deleteProduct(int id)
	{
		repository.deleteById(id);
		return "Product deleted successfully ! "+id;
	}
	
	//update
	public Product updateProduct(Product product)
	{
		Product existingProduct=repository.findById(product.getId()).orElse(null);
		existingProduct.setName(product.getName());
		existingProduct.setQuantity(product.getQuantity());
		existingProduct.setPrice(product.getPrice());
		return repository.save(existingProduct);

	}
}
