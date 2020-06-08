package entities;

public class IndividualTaxpayer extends Taxpayer {
	private double healthExpenditure;
	
	
	public IndividualTaxpayer(String name, double anualIncome, double healthExpenditure) {
		super(name, anualIncome);
		this.healthExpenditure = healthExpenditure;
	}

	
	public double getHealthExpenditure() {
		return healthExpenditure;
	}
	public void setHealthExpenditure(double healthExpenditure) {
		this.healthExpenditure = healthExpenditure;
	}

	
	@Override
	public double calculateTax() {
		if(this.getAnualIncome()<20000) {
			return this.getAnualIncome()*0.15 - this.healthExpenditure*0.5;
		}
		else {
			return this.getAnualIncome()*0.25 - this.healthExpenditure*0.5;
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+String.format("Health Expenditure: $%.2f \nTaxed Income: $%.2f",this.healthExpenditure,this.taxedIncome());
	}

}
