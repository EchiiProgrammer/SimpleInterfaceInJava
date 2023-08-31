package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.service.ContractService;
import model.service.PaypalService;

public class Program {

	public static void main(String[] args) {
	
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Entre os dados do contrato:");
		System.out.print("Numero: ");
		int number = sc.nextInt();
		sc.nextLine();
		System.out.print("Data (dd/MM/yyy): ");
		LocalDate date = LocalDate.parse(sc.nextLine(), dateFormat);
		System.out.print("Valor do contrato: ");
		double totalValue = sc.nextDouble();
		System.out.print("Entre com o numero de Parcelas: ");
		int months = sc.nextInt();

		Contract contract = new Contract(number, date, totalValue);
		ContractService service = new ContractService(new PaypalService());	
		
		service.processContract(contract, months);
		
		System.out.println("Parcelas:");
		for (Installment installments : contract.getInstallments()) {
			System.out.println(installments);
		}
		
		
		
		
		sc.close();
	}

}
