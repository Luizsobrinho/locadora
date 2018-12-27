package model.services;

import model.entites.CarRental;
import model.entites.Invoice;

public class RentalService {

	private Double pricePerDay;
	private Double pricePerHour;

	private TaxService taxService;

	public RentalService(Double pricePerDay, Double pricePerHour,TaxService taxservice) {

		this.pricePerDay = pricePerDay;
		this.pricePerHour = pricePerHour;
		this.taxService = taxservice;
	}

	public void processInvoice(CarRental carRental) {
		long t1 = carRental.getStart().getTime();
		long t2 = carRental.getFinish().getTime();

		double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		double basicpayment;
		if (hours <= 12) {
			basicpayment = Math.ceil(hours) * pricePerHour;
		} else {
			basicpayment = Math.ceil(hours / 24) * pricePerDay;
		}

		double tax = taxService.tax(basicpayment);
		carRental.setInvoice(new Invoice(basicpayment, tax));
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	

}
