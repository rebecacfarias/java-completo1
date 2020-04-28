package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HourContract {
	private Worker worker;
	private int id;
	private Date date;
	private double valuePerHour;
	private int hours;
	public static List<HourContract> listOfAllContracts = new ArrayList<>();
	
	//constructor
	public HourContract(Worker worker, Date date,double valuePerHour,int hours){
		this.worker = worker;
		setDate(date);
		setValuePerHour(valuePerHour);
		setHours(hours);
	}
	
	//setters
	public void setDate(Date date) {
		this.date = date;
	}
	public void setValuePerHour(double valuePerHour) {
		this.valuePerHour = valuePerHour;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}

	//getters
	public Date getDate() {
		return this.date;
	}
	public double getValuePerHour(){
		return this.valuePerHour;
	}
	public int getHours() {
		return this.hours;
	}
	public int getId() {
		return this.id;
	}
	
	
	public double totalValue() {
		if(getHours()*getValuePerHour()<worker.getBaseSalary())
			return worker.getBaseSalary();
		return getHours()*getValuePerHour();
	}
	
	public String formatTotalValue(){
		return String.format("%.2f", totalValue());
	}
	
	//adicionar toString do worker e o ID
	public String toString() {
		return String.format("\n DATE: %s \n VALUE PER HOUR: %.2f \n HOURS: %d \n TOTAL PAYMENT: %s \n",getDate(),getValuePerHour(),getHours(),formatTotalValue())
				+this.worker.toString();
	}
	
	public String toStringJustContract() {
		return String.format("\n DATE: %s \n VALUE PER HOUR: %.2f \n HOURS: %d \n TOTAL PAYMENT: %s \n",getDate(),getValuePerHour(),getHours(),formatTotalValue());
	}
	
	public static void generateId(HourContract hc) {
		int newID;
		do {
	      newID = (int) Math.random()*1000;
		}while(idCheck(newID));
		hc.id = newID;
	}
	
	public static boolean idCheck(int id){
		for(HourContract hc : listOfAllContracts) {
			if(hc.getId() == id) {
				return true;
			}
		}
		return false;
	}
	
	public static void showAllContracts() {
		if(listOfAllContracts.isEmpty())
			System.out.println("NO CONTRACTS FOUND");
		else {
			for(HourContract hc : listOfAllContracts) {
				System.out.println(hc.toString());
			}
		}
	}
	
	
}
