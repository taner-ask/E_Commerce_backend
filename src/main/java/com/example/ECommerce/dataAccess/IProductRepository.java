package com.example.ECommerce.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ECommerce.entities.Product;

public interface IProductRepository extends JpaRepository<Product, Integer>{

	
}
