package com.example.ECommerce.business.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductRequest {
	
	private double price;
	
	private String image;
	
	private String title;
	
	private String description;
}

