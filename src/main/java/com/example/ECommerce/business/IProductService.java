package com.example.ECommerce.business;

import java.util.List;

import com.example.ECommerce.business.requests.CreateProductRequest;
import com.example.ECommerce.business.requests.UpdateProductRequest;
import com.example.ECommerce.business.responses.GetAllProductResponse;
import com.example.ECommerce.business.responses.GetByIdProductResponse;

public interface IProductService {
	List<GetAllProductResponse> getAllProducts();
	void add(CreateProductRequest createProductReequest);
	GetByIdProductResponse getById(int id);
	UpdateProductRequest updateProductRequest(UpdateProductRequest updateProductRequest);
	void delete(int id);

}
