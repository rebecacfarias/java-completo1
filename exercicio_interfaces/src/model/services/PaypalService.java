package model.services;

public class PaypalService implements OnlinePaymentService {
	private static final double FEE_PERCENT = 0.02;
	private static final double INTEREST_PERCENT = 0.01;
	
	
	@Override
	public double paymentFee(double amount) {
		return amount * FEE_PERCENT;
	}
	@Override
	public double monthlyInterest(double amount, int month) {
		return amount * INTEREST_PERCENT * month;
	}
	
	
}
