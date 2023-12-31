package com.example.micro.demo.first.microproject;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Product {
	@Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private Long id;

	    private String name;
	    private double price;
		public Product(String name, double price) {
			 this.name=name;
			  this.price=price;
		}
		protected Product() {
			
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getPrice() {
			return price;
		}
		public void setPrice(double price) {
			this.price = price;
		}
		 @Override
		    public String toString() {
		        return String.format("Product[id=%d, name='%s', price=%.2f]", id, name, price);
		    }

	    
	}


