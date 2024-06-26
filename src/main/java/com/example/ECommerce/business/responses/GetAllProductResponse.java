package com.example.ECommerce.business.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllProductResponse {
	private int id;
	
	private double price;
	
	private String image;
	
	private String title;
	
	private String description;
}
