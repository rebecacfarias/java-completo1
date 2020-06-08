package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.services.ContractService;
import model.services.PaypalService;

public class ContractTest {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		Scanner sc = new Scanner(System.in);
		//LEITURA DE DADOS
		System.out.println("Enter contract data");
		
		//NUMERO DO CONTRATO
		System.out.print("Number: ");
		int number = sc.nextInt();
		sc.nextLine();

		//DATA
		System.out.print("Date(dd/MM/yyyy): ");
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		boolean goOn = false;
		//laço para tratar exceção da data e só aceitar no formato sugerido
		while(!goOn) {
			try {
				date = sdf.parse(sc.nextLine());
				goOn = true;
			} catch (ParseException e) {
				System.out.println("INVALID DATE FORMAT");
				continue;
			} 
		}
		
		//valor do contrato
		System.out.print("Contract value: $");
		double value = sc.nextDouble();
		sc.nextLine();
		
		//numero de parcelas
		System.out.print("Number of installments: ");
		int installmentsNumber = sc.nextInt();
		
		//INSTANCIAÇÃO 
		Contract contract = new Contract(number,date,value,installmentsNumber);
		
		ContractService contractService = new ContractService(new PaypalService());
		
		contractService.processInstallments(contract);
		
		
		
		//SAÍDA DE DADOS
		contract.getInstallments();
		
		
		
		
		
		
		sc.close();

	}

}
