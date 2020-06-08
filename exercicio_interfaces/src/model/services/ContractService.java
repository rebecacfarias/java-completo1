package model.services;

import java.util.Calendar;
import java.util.Date;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;

	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processInstallments(Contract contract) {
		double basicAmount = contract.getTotalValue() / contract.getNumberOfInstallments();
		double updatedAmount, finalAmount;
		for(int i = 1; i<=contract.getNumberOfInstallments(); i++) {
			updatedAmount = basicAmount + onlinePaymentService.monthlyInterest(basicAmount,i);
			finalAmount = updatedAmount + onlinePaymentService.paymentFee(updatedAmount);
			contract.addInstallments(new Installment(addMonths(contract.getDate(),i) , finalAmount));
		}
		
	}
	
	private Date addMonths(Date date, int n) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.MONTH, n);
		return cal.getTime();
	}
	
	
}
