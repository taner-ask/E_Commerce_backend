package com.example.ECommerce.restApi;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.ECommerce.business.IProductService;
import com.example.ECommerce.business.requests.CreateProductRequest;
import com.example.ECommerce.business.requests.UpdateProductRequest;
import com.example.ECommerce.business.responses.GetAllProductResponse;
import com.example.ECommerce.business.responses.GetByIdProductResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class ProductsControllers {
	private IProductService productService;

	
	@GetMapping("/getallproducts")
	public List<GetAllProductResponse> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public GetByIdProductResponse getById(@PathVariable int id){
		return productService.getById(id);
	}
	
	@PostMapping()
	@ResponseStatus(code=HttpStatus.CREATED)
	public void add(@RequestBody CreateProductRequest createProductRequest) {
		productService.add(createProductRequest);
	}
	
	@PutMapping()
	public void update(@RequestBody UpdateProductRequest updateProductRequest) {
		this.productService.updateProductRequest(updateProductRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable int id) {
		this.productService.delete(id);
	}

}
