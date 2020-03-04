package application;
import java.util.Locale;
import java.util.Scanner;
import util.CurrencyConverter;

/*
 CLASSES UTILITARIAS
 Exercício para calcular a quantidade a ser paga 
 em reais para comprar X dolares, acrescentando o IOF.
 */
public class Program {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		double price,dollars;
		
		System.out.print("What is the dollar price? ");
		price = sc.nextDouble();
		System.out.print("How many dollars wil be bought? ");
		dollars = sc.nextDouble();
		System.out.printf("Amount to be paid in reais = %.2f\n",CurrencyConverter.totalReais(price,dollars));
		
		sc.close();
	}

}
