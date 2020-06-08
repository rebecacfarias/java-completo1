package application;
import java.util.Locale;
import java.util.Scanner;

import entities.*;

/*
 EXERCICIO SOBRE CLASSES E MÉTODOS ABSTRATOS
 
 Contabilizar impostos de pessoa física e jurídica
 
*/


public class TaxpayerTest {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		char control;
		int counter = 0;
		Taxpayer taxpayer = null;
		
		do {
			counter++;
			
			System.out.printf("\nEnter #%d Taxpayer data\n", counter);
			char taxpayerType;
			do {
				System.out.print("Individual or Corportate (i/c)? ");
				taxpayerType = sc.nextLine().charAt(0);
				taxpayerType = Character.toLowerCase(taxpayerType);
			}while(taxpayerType != 'i' && taxpayerType != 'c');
			System.out.print("Name: ");
			String taxpayerName = sc.nextLine();
			System.out.print("Anual Income: $");
			double taxpayerIncome = sc.nextDouble();
			sc.nextLine();
			
			
			if(taxpayerType == 'i') {
				double healthExpenditure;
				do {
					System.out.print("Health Expenditure: $");
					healthExpenditure = sc.nextDouble();
					sc.nextLine();
				}while(healthExpenditure<0);
				
				taxpayer = new IndividualTaxpayer(taxpayerName,taxpayerIncome,healthExpenditure);
			}else {
				int employees;
				do {
					System.out.print("Employees: ");
					employees = sc.nextInt();
					sc.nextLine();
				}while(employees<0);
				
				taxpayer = new CorporateTaxpayer(taxpayerName,taxpayerIncome,employees);
			}
			
			Taxpayer.taxpayersList.add(taxpayer);
			System.out.print("Register another Taxpayer (y/n)? -> ");
			control = sc.nextLine().charAt(0);
			control = Character.toLowerCase(control);
		}while(control == 'y');
		
		System.out.println("LIST OF TAXPAYERS:");
		Taxpayer.showTaxpayers();
		System.out.printf("\nTOTAL TAXES: $%.2f\n", Taxpayer.totalTaxes());
		
		sc.close();

	}

}
