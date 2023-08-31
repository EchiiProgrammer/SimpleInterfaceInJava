package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment {
	
	
	private static DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate dueDate;
	private double amount;
	
	
	
	
	public Installment(LocalDate dueDate, double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}
	
	
	public LocalDate getDueDate() {
		return dueDate;
	}

	public double getAmount() {
		return amount;
	}


	@Override
	public String toString() {
		return dueDate.format(dateFormat) + " - " + String.format("%.2f", amount);
	}
	
	


}
