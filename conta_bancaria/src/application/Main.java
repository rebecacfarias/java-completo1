package application;
import entities.ContaBancaria;
import java.util.Scanner;
import java.util.Locale;

public class Main {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String numConta, nomeCliente;
		char op;
		float deposito,saque;
		cabecalho("CADASTRANDO");
		System.out.print("CONTA BANCARIA: ");
		numConta = sc.nextLine();
		System.out.print("CLIENTE: ");
		nomeCliente = sc.nextLine();
		nomeCliente = nomeCliente.toUpperCase();
		ContaBancaria novaConta;
		do {
		  System.out.print("DESEJA FAZER DEPOSITO INICIAL? (S/N)");
		  op = sc.next().charAt(0);
		  op = Character.toUpperCase(op);
		}while(op!='S' && op!='N');
		
		if(op=='S') {
			System.out.print("DEPOSITO: $");
			deposito = sc.nextFloat();
			sc.nextLine();
			novaConta = new ContaBancaria(numConta,nomeCliente,deposito);
			
			
		}else {
			novaConta = new ContaBancaria(numConta,nomeCliente);
			System.out.println("SALDO: $0.00");
		}
		
		System.out.printf("\n>>> PRESSIONE ENTER PARA CONTINUAR <<<");
		sc.nextLine();
		
		do {
			cabecalho("ACESSANDO");
			System.out.printf("DADOS >>> %s",novaConta.toString());
			System.out.printf("\n"
				+ "1. DEPOSITO "
				+ "\n2. SAQUE"
				+ "\n0. SAIR"
				+ "\nDIGITE 1 PARA DEPOSITO, 2 PARA SAQUE OU 0 PARA SAIR: >>> ");
			op = sc.next().charAt(0);
			if(op=='1') {
				System.out.print("VALOR DO DEPOSITO: $");
				deposito = sc.nextFloat();
				novaConta.fazerDeposito(deposito);
			}else if(op == '2'){
				System.out.print("VALOR DO SAQUE: $");
				saque = sc.nextFloat();
				novaConta.fazerSaque(saque);
			}else if(op=='0') break;
			System.out.println("PRESSIONE QUALQUER NUMERO PARA REALIZAR OUTRA OPERACAO, 0(ZERO) PARA SAIR");
			op = sc.next().charAt(0);
		}while(op!='0');		
		
		
		sc.close();
	}
	
	public static void cabecalho(String status) {
		System.out.printf("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		System.out.printf("\n-----%s-----CONTA-----BANCARIA-----\n",status);
	}


}
