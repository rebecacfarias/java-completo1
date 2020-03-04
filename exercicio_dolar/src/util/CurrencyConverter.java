package util;

public class CurrencyConverter {
	
	public static double totalReais(double dollarPrice, double dollars) {
		double subtotal = dollars*dollarPrice;
		return subtotal+subtotal*0.06;
	}
}
