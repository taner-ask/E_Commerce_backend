package com.example.ECommerce.business;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.ECommerce.business.requests.CreateProductRequest;
import com.example.ECommerce.business.requests.UpdateProductRequest;
import com.example.ECommerce.business.responses.GetAllProductResponse;
import com.example.ECommerce.business.responses.GetByIdProductResponse;
import com.example.ECommerce.core.utilities.mappers.IModelMapperService;
import com.example.ECommerce.dataAccess.IProductRepository;
import com.example.ECommerce.entities.Product;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductManager implements IProductService{
	
	private IProductRepository productRepository;
	private IModelMapperService modelMapperService;


	@Override
	public List<GetAllProductResponse> getAllProducts() {
		
		List<Product> products = productRepository.findAll();
		
		List<GetAllProductResponse> productResponse = products.stream()
				.map(product -> this.modelMapperService.forResponse()
						.map(product, GetAllProductResponse.class)).collect(Collectors.toList());
		
		return productResponse;
	}

	@Override
	public void add(CreateProductRequest createProductReequest) {
		// TODO Auto-generated method stub
		Product product = this.modelMapperService.forRequest().map(createProductReequest, Product.class);
		
		this.productRepository.save(product);
	}

	@Override
	public GetByIdProductResponse getById(int id) {

		Product product = this.productRepository.findById(id).orElseThrow();
		GetByIdProductResponse response = this.modelMapperService.forResponse().map(product, GetByIdProductResponse.class);		
		return response;
	}

	

	@Override
	public UpdateProductRequest updateProductRequest(UpdateProductRequest updateProductRequest) {
		Product product = this.modelMapperService.forRequest().map(updateProductRequest, Product.class);
		this.productRepository.save(product);
		
		return null;
	}
	
	
	@Override
	public void delete(int id) {

		this.productRepository.deleteById(id);
	}


}
