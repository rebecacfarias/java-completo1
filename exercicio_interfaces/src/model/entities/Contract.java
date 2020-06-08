package model.entities;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Contract {
	private Integer number;
	private Date date;
	private Double totalValue;
	private Integer numberOfInstallments;
	private List<Installment> installmentsList = new ArrayList<>();
	
	
	public Contract(Integer number, Date date, Double totalValue,Integer numberOfInstallments) {
		this.number = number;
		this.date = date;
		this.totalValue = totalValue;
		this.numberOfInstallments = numberOfInstallments;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Date getDate() {
		return date;
	}
	
	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}
	
	public void setNumberOfInstallments(Integer numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
	
	public Integer getNumberOfInstallments() {
		return numberOfInstallments;
	}
	

	
	
	//METODOS PARA A LISTA

	public void getInstallments() {
		for(Installment i : installmentsList) {
			System.out.println(i.toString());
		}
	}
	
	public void addInstallments(Installment i) {
		installmentsList.add(i);
	}
	public void removeInstallment(Installment i) {
		installmentsList.remove(i);
	}

	
	
	
	
}
