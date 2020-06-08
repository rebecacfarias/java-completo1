package model.services;

public interface OnlinePaymentService {
		double paymentFee(double amount);
		double monthlyInterest(double amount, int month);
}
