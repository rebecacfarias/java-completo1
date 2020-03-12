package application;
import java.util.Scanner;
import entities.RegistroDeAluguel;

/*
 PROGRAMA PARA GERENCIAR ALUGUEL DE QUARTOS DE PENSIONATO
 */
public class Program {

	public static void main(String[] args){
	  System.out.print(">>>PENSIONATO - REGISTRO DE ALUGUEL<<<");
	  Scanner sc = new Scanner(System.in);
	  char ans; //variavel de controle de laço
      String nome,email; //variaveis para coletar dados
	  int numQuarto,i,contTeste=0,op; //contadores,controle de laço
	  RegistroDeAluguel []aluguel = new RegistroDeAluguel[10]; //vetor para registrar os 10 alugueis
		
	  do {
		  showOptions(); //metodo para printar opcoes
		  do {
			  System.out.print("(0, 1, 2 ou 3)>");
			  op = sc.nextInt();
			  sc.nextLine();
		  }while(op>3 || op<0);
	//opcao 1 - alugando quartos
	   if(op==1) {
		do {
		    System.out.println(">QUARTOS VAGOS:");
			for(i=0;i<10;i++){
				if(RegistroDeAluguel.quartos[i]==0) {
					contTeste++;
					System.out.print(i+" - ");
				}
			}
			if(contTeste == 0) {
				System.out.println("TODOS OS QUARTOS ESTAO OCUPADOS");
			}else {
				System.out.printf("\n>NOME: ");
				nome = sc.nextLine();
				System.out.printf(">EMAIL: ");
				email = sc.next();
				do {
					System.out.printf(">NUMERO DO QUARTO:");
					numQuarto = sc.nextInt();
					sc.nextLine();
				}while(numQuarto>9 || numQuarto <0);
				if(RegistroDeAluguel.quartos[numQuarto] == 0) {
					System.out.println("ALUGUEL REGISTRADO");
					aluguel[numQuarto] = new RegistroDeAluguel(nome,email);
					aluguel[numQuarto].alugaQuarto(numQuarto);
				}
				else{
					System.out.printf("\nQUARTO JA ALUGADO!\n");
				}
			}
			System.out.print("DESEJA REGISTRAR OUTRO ALUGUEL(S/N)? >");
			ans = sc.nextLine().charAt(0);
			ans = Character.toUpperCase(ans);
			
		}while(ans=='S');
	   }
	  // opcao 2 - desocupando quartos
	   else if(op==2) {
		   System.out.println(">>>PENSIONATO - DESOCUPAR QUARTO<<<");
		   System.out.print("NUM DO QUARTO A SER DESOCUPADO: ");
		   numQuarto = sc.nextInt();
		   sc.nextLine();
		   if(RegistroDeAluguel.quartos[numQuarto]==1) {
			   RegistroDeAluguel.desocupaQuarto(numQuarto,aluguel);
			   System.out.println("QUARTO DESOCUPADO COM SUCESSO");
		   }else {
			   System.out.println("QUARTO JA ESTA DESOCUPADO");
		   }
	   }
	  // opcao 3 - mostrando quartos alugados
	   else if(op==3) {
		   System.out.printf("\n>>>QUARTOS ALUGADOS<<<\n");
		   RegistroDeAluguel.showRents(aluguel);
	   }
	  }while(op!=0); //fim de laço
		
		sc.close();

	}
	
	public static void showOptions() {
		System.out.println(">>> PENSIONATO <<<");
		System.out.println("1. ALUGAR QUARTO");
		System.out.println("2. DESOCUPAR QUARTO");
		System.out.println("3. MOSTRAR QUARTOS ALUGADOS");
		System.out.println("0. SAIR");
	}

}
