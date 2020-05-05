package application;
import entities.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

/*
 EXERCÍCIO DE HERANÇA E POLIMORFISMO
 REGISTRAR PRODUTOS (NORMAL, IMPORTADO OU USADO)
 IMPORTADO -> POSSUI TAXA DE IMPORTAÇÃO
 USADO -> POSSUI DATA DE FABRICAÇÃO 
 
*/

public class ProductTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		char control;
		int counter = 0;
		Product product = null;
		
		do {
			counter++;
			System.out.printf("\nProduct #%d data\n",counter);
			
			char productType;
			do {
				System.out.print("Common, used or imported?(c,u,i) -> ");
				productType = sc.nextLine().charAt(0);
				productType = Character.toLowerCase(productType);
			}while(productType != 'u' && productType != 'c' && productType != 'i');
			
			System.out.print("Name: ");
			String productName = sc.nextLine();
			System.out.print("Price: $");
			Double productPrice = sc.nextDouble();
			sc.nextLine();
			
			if(productType == 'u'){
				System.out.print("Manufacture date(dd/MM/yyyy): ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date manufactureDate = null;
				boolean goOn = false;
				while(!goOn) {
					try {
						manufactureDate = sdf.parse(sc.nextLine());
						goOn = true;
					} catch (ParseException e) {
						System.out.println("INVALID DATE FORMAT");
						continue;
					} 
				}
				product = new UsedProduct(productName,productPrice,manufactureDate);
			}
			else if(productType == 'i'){
				System.out.print("Customs fee: $");
				double customFee = sc.nextDouble();
				sc.nextLine();
				product = new ImportedProduct(productName,productPrice,customFee);
			}
			else {
				product = new Product(productName,productPrice);
			}
			
			
			Product.productsList.add(product);
			System.out.print("Register another Product? (y/n)");
			control = sc.nextLine().charAt(0);
			control = Character.toLowerCase(control);
		}while(control == 'y');
		
		System.out.println("Products List: ");
		Product.displayProductList();
		
		
		sc.close();

	}

}
