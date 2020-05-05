package entities;

public class ImportedProduct extends Product {
	
	private double customFee;

	public ImportedProduct(String name, double price, double customFee) {
		super(name,price);
		this.setPrice(price+customFee);
		this.customFee = customFee;
	}

	public double getCustomFee() {
		return customFee;
	}

	public void setCustomFee(double customFee) {
		this.customFee = customFee;
	}
	
	@Override 
	public String priceTag(){
		return super.priceTag()+String.format(" (Customs fee: %.2f)",this.customFee);
	}

}
