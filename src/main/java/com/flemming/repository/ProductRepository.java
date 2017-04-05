package com.flemming.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.flemming.domain.Product;

@Repository
public class ProductRepository {

	private List<Product> productsList;
	
	public ProductRepository() {
		productsList = new ArrayList<>();
		Product product1 = new Product(1L, "product1");
		Product product2 = new Product(2L, "product2");
		productsList.add(product1);
		productsList.add(product2);
	}
	
	public List<Product> getAllProducts() {
		return productsList;
	}
	
	public Product getProductById(Long id) {
		for(int i = 0; i < productsList.size(); i++) {
			if(productsList.get(i).getId().equals(id)) {
				return productsList.get(i);
			}
		}
		return null;
	}
	
	public void deleteProduct(Long id) {

		int index = 0;

		for (int i = 0; i < productsList.size(); i++) {
			if (productsList.get(i).getId().equals(id)) {
				index = i;
				break;
			}
		}

		productsList.remove(index);

	}
	
	public void addProduct(Product product) {
		productsList.add(product);
	}
	
}
