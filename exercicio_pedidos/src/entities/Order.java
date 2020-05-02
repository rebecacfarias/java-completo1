package entities;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;



public class Order {
	private Date moment;
	private OrderStatus status;
	private Client client;
	private List<OrderItem> listOfOrderItems = new ArrayList<>();
	
	public Order(Date moment, OrderStatus status, Client client) {
	
		this.moment = moment;
		this.status = status;
		this.client = client;
	}
	
	public Date getMoment() {
		return moment;
	}
	public String getMomentString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(moment);
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public void addItem(OrderItem item) {
		this.listOfOrderItems.add(item);
	}
	public void removeItem(OrderItem item) {
		this.listOfOrderItems.remove(item);
	}
	public double total() {
		double sum=0;
		for(OrderItem item : this.listOfOrderItems) {
			sum+= item.subTotal();
		}
		return sum;
	}
	
	public void showItemsList() {
		int counter = 1;
		for(OrderItem item : this.listOfOrderItems) {
			System.out.println("#"+counter);
			System.out.println(item.toString());
			counter++;
		}
		System.out.printf("\n TOTAL: $ %.2f", this.total());
	}
	
	public String toString() {
		return "ORDER DATE: "+this.getMoment()
				+"\nORDER STATUS: "+ this.getStatus()
				+"\n"+client.toString();
	}
	
	
	
	
	
	

}
