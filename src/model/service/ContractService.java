package model.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
	
	
	private OnlinePaymentService onlinePaymentService;
	Contract contract;
	DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	
	
	
	public ContractService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
		
		public void processContract(Contract contract, int months) {
			double basicQuota = contract.getTotalValue() / months;
	        
			
			for (int i = 1; i <= months; i++) {
	            LocalDate dueDate = contract.getDate().plusMonths(i);
	            double interest = onlinePaymentService.interest(basicQuota, i);
	            double fee = onlinePaymentService.paymentFee(basicQuota + interest);
	            double quota = basicQuota + interest + fee;
	            contract.getInstallments().add(new Installment(dueDate, quota));
	        }
		
		
		
		
		
		
	}

}
