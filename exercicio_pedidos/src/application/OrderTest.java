package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

/*
 EXERCÍCIO DE COMPOSIÇÃO, SIMULAÇÃO REGISTRO DE PEDIDOS
*/

public class OrderTest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Client client;
		Product product;
		OrderItem item;
		Order order;
		String stringStatus;
		Date clientBirthDate = null;
		
		
		System.out.println("-> CLIENT DATA:");
		System.out.print("	>NAME: ");
		String clientName = sc.nextLine();
		System.out.print("	>EMAIL: ");
		String clientEmail = sc.nextLine();
		System.out.print("	>BIRTHDATE(dd/MM/yyyy): ");
		
		boolean goOn = false;
		while(!goOn) {
			try {
				clientBirthDate = sdf.parse(sc.nextLine());
				goOn = true;
			} catch (ParseException e) {
				System.out.println("INVALID DATE FORMAT");
				continue;
			} 
		}
		
		client = new Client(clientName,clientEmail,clientBirthDate);
				
		System.out.println("-> ORDER DATA:");
		do {
			System.out.print("	>STATUS: ");
			stringStatus = sc.nextLine().toUpperCase();
		}while(stringStatus.intern() != "PENDING_PAYMENT" && stringStatus.intern() != "DELIVERED" && stringStatus.intern() != "SHIPPED" && stringStatus.intern() != "PROCESSING");
		OrderStatus os = OrderStatus.valueOf(stringStatus);
		
		Date current = new Date();
		order = new Order(current,os,client);
		
		System.out.println("	>ITEMS:");
		char control;
		int counter = 0;
		do {
			counter++;
			System.out.println("	  >ENTER ITEM #"+counter+" DATA ");
			System.out.print("			PRODUCT NAME: ");
			String productName = sc.nextLine();
			System.out.print("			PRODUCT PRICE:");
			double productPrice = sc.nextDouble();
			sc.nextLine();
			System.out.print("			QUANTITY:");
			int productQuantity = sc.nextInt();
			sc.nextLine();
			
			product = new Product(productName, productPrice);
			item = new OrderItem(productQuantity,product);
			order.addItem(item);
			
			System.out.printf("\n ITEM ADDED. \n");
			System.out.print("CONTINUE ADDING ITEMS?(Y/N) >");
			control = sc.nextLine().charAt(0);
			control = Character.toUpperCase(control);
			
		}while(control=='Y');
		
		System.out.println("ORDER SUMMARY: ");
		System.out.println(order.toString());
		order.showItemsList();
		
		
		
		
		
		sc.close();
	}	

}
