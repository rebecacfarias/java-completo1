package entities;

public class CorporateTaxpayer extends Taxpayer {
	private int countEmployees;
		
	public CorporateTaxpayer(String name, double anualIncome, int countEmployees) {
		super(name, anualIncome);
		this.countEmployees = countEmployees;
	}
	
	public int getCountEmployees() {
		return countEmployees;
	}
	public void setCountEmployees(int countEmployees) {
		this.countEmployees = countEmployees;
	}


	@Override
	public double calculateTax() {
		if(this.countEmployees>10) {
			return this.getAnualIncome()*0.14;
		}
		else{
			return this.getAnualIncome()*0.16;
		}
	}
	
	@Override
	public String toString() {
		return super.toString()+String.format("Employees: %d \nTaxed Income: $%.2f ",this.countEmployees,super.taxedIncome());
	}



}
