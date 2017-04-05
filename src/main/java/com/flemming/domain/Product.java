package com.flemming.domain;

public class Product {

	private Long id;
	private String name;

	public Product() {
	}
	
	public Product(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + "]";
	}

}
