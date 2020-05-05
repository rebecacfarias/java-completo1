package entities;

import java.util.ArrayList;
import java.util.List;

public class Product {
	private String name;
	private double price;
	
	public static List<Product> productsList = new ArrayList<>();
	
	
	
	public Product(String name, double price) {
		this.name = name;
		this.price = price;
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


	public String priceTag(){
		return String.format(" $ %.2f ", this.price);
	}
	public String toString() {
		return String.format(" %s - %s",this.name,this.priceTag());
	}
	
	//STATIC LIST FUNCTIONS
	
	public static void displayProductList() {
		for(Product p : productsList) {
			System.out.println(p.toString());
			System.out.println(" ");
		}
	}
}
