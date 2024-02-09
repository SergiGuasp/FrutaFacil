package com.example.demo;

import java.io.Serializable;
import jakarta.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity(name="Products")
@Table(name="products")
@NamedQuery(name="Products.findAll", query="SELECT p FROM Products p")
public class Products implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id_Products;

	private String description;

	private String name;

	private BigDecimal price;


	public Products() {
	}

	public int getId_Products() {
		return this.id_Products;
	}

	public void setId_Products(int id_Products) {
		this.id_Products = id_Products;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}



}