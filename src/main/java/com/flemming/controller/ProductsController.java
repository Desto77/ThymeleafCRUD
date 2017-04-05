package com.flemming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.flemming.domain.Product;
import com.flemming.repository.ProductRepository;

@Controller	
public class ProductsController {

	private ProductRepository productRepository;
	
	@Autowired
	public ProductsController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String showProducts(Model model) {
		model.addAttribute("products", productRepository.getAllProducts());
		return "products";
	}

	@RequestMapping(value = "/product/delete/{id}", method = RequestMethod.GET)
	public String deleteProduct(@PathVariable Long id) {
		productRepository.deleteProduct(id);
		return "redirect:/products";
	}
	
	@RequestMapping(value = "/product/edit/{id}", method = RequestMethod.GET)
	public String editProduct(@PathVariable Long id, Model model) {
		model.addAttribute("product", productRepository.getProductById(id));
		return "editproductform";
	}
	
	@RequestMapping(value = "/product", method = RequestMethod.POST)
	public String saveProduct(@ModelAttribute Product product) {
		System.out.println(product.getName());
		productRepository.addProduct(product);
		return "redirect:/products";
	}
	
	

}
