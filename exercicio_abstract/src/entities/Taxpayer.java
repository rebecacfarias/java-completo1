package entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Taxpayer {
	private String name;
	private double anualIncome;
	public static List<Taxpayer> taxpayersList = new ArrayList<>();
	
	public Taxpayer(String name, double anualIncome) {
		this.name = name;
		this.anualIncome = anualIncome;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getAnualIncome() {
		return anualIncome;
	}
	public void setAnualIncome(double anualIncome) {
		this.anualIncome = anualIncome;
	}
	
	public double taxedIncome() {
		return this.anualIncome-this.calculateTax();
	};
	public String toString() {
		return String.format("\nName: %s \nAnual Income: $%.2f \nAnual Taxes: %.2f \n",this.name,this.anualIncome,this.calculateTax());
	}
	
	public abstract double calculateTax();
	
	
	
	//OPERAÇÕES COM A LISTA
	public static double totalTaxes() {
		double taxesSum = 0.0;
		
		for(Taxpayer tp : taxpayersList) {
			taxesSum+= tp.calculateTax();
		}
		
		return taxesSum;
	}
	
	public static void showTaxpayers() {
		for(Taxpayer tp : taxpayersList) {
			System.out.println(tp.toString());
		}
	}
	
	
	
	
	
	
}
