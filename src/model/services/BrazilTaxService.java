package model.services;

public class BrazilTaxService {
	
	public BrazilTaxService() {
		// TODO Auto-generated constructor stub
	}
	public double tax(double amount) {
		if (amount <= 100.0) {
			return amount * 0.2;
		} else {
			return amount * 0.15;
		}

	}
}
