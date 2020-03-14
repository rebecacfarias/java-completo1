package application;
import java.util.Scanner;
import entities.Funcionario;


/*
 PROGRAMA PARA TESTAR AS FUNCIONALIDADES DA CLASSE FUNCIONARIO
 OBJETIVO: CADASTRAR, LISTAR, REMOVER E ALTERAR DADOS DE FUNCIONARIOS
 
 EXERCICIO FEITO POR REBECA FARIAS
*/

public class FuncionarioTeste {
	static Scanner sc = new Scanner(System.in); //scanner para todos os metodos
	
	//MAIN
	public static void main(String[] args) {

		menuInicial();

	}
	
	//MENU INICIAL
	public static void menuInicial() {
		int op;
		do {
			System.out.println("(1) CADASTRAR FUNCIONARIOS");
			System.out.println("(2) ATUALIZAR DADOS(NOME/SALARIO)");
			System.out.println("(3) LISTAR FUNCIONARIOS ");
			System.out.println("(4) REMOVER FUNCIONARIOS");
			System.out.println("(5) SAIR");
			System.out.print("> ");
			op = sc.nextInt();
		}while(op>5 || op<0);
		sc.nextLine(); //LIMPEZA DE BUFFER
		
		//CHAMA OS METODOS PARA CADA OPCAO
		switch(op) {
			case 1: cadastrarFuncionario();break;
			case 2: atualizarDados();break;
			case 3: listarFuncionarios();break;
			case 4: removerFuncionario();
		}
		
	} //FIM DE MENU INICIAL
	
//INICIO DE METODOS PARA CADA FUNCIONALIDADE
	//CADASTRAR FUNCIONARIOS
	public static void cadastrarFuncionario() {
		//VARIAVEIS AUXILIARES
		int id;
		String nome;
		float salario;
		//OBJETO FUNCIONARIO
		Funcionario funcionario;
		
		//COLETA DE DADOS
		System.out.print("> ID: ");
		id = sc.nextInt();
		//TESTA SE O FUNCIONARIO JA É CADASTRADO
		if(Funcionario.checaExistencia(id)) {
			System.out.println(">>>ERRO - ID JA CADASTRADO<<<");
		}else {
		//CASO O ID NAO EXISTA, REALIZA O CADASTRO
			sc.nextLine();
			System.out.print("> NOME: ");
			nome = sc.nextLine();
			System.out.print("> SALARIO: ");
			salario = sc.nextFloat();
			sc.nextLine();
			funcionario = new Funcionario(id,nome,salario);
			Funcionario.adicionaNaLista(funcionario);//ADICIONA NA LISTA DE FUNCIONARIOS
			System.out.println(">>>FUNCIONARIO CADASTRADO COM SUCESSO<<<");
		}
		voltarAoMenu(); //METODO PARA VOLTAR AO MENU INICIAL
		
	}//FIM DE CADASTRO DE FUNCIONARIOS
	
	//ATUALIZACAO DE DADOS
	public static void atualizarDados() {
	  int id,op; //VARIAVEIS AUXILIARES
	  System.out.print(">>>INSIRA O ID DO FUNCIONARIO PARA ALTERAR DADOS: ");
	  id = sc.nextInt();
	  sc.nextLine();
	  //CHECA SE O FUNCIONARIO EXISTE
	  if(Funcionario.checaExistencia(id)) {
		do {
			System.out.println("(1) ATUALIZAR NOME");
			System.out.println("(2) AJUSTAR SALARIO");
			System.out.println("(3) VOLTAR");
			System.out.print("> ");
			op = sc.nextInt();
		}while(op>3 || op<1);
		sc.nextLine();
		//ALTERA NOME
		if(op == 1) {
			System.out.print(">>> INSIRA O NOME ATUALIZADO: ");
			String novoNome = sc.nextLine();
			Funcionario.alteraNome(id, novoNome);
			
			voltarAoMenu();
		}
		//ALTERA SALARIO
		else if(op==2) {
			System.out.print(">>> INSIRA PORCENTAGEM(%) DO AJUSTE SALARIAL: ");
			float porcentagem = sc.nextFloat();
			sc.nextLine();
			Funcionario.ajustaSalario(id, porcentagem);
			voltarAoMenu();
		}
		else menuInicial();
	//CASO O ID NAO EXISTA...
	  }else {
		  System.out.println(">>>FUNCIONARIO NAO ENCONTRADO<<<");
		  voltarAoMenu();
	  }
	}//FIM DE ALTERAÇÃO DE DADOS
	
	//LISTAR FUNCIONARIOS
	public static void listarFuncionarios() {
		Funcionario.exibeFuncionarios(); //CHAMA O METODO DA CLASSE QUE EXIBE A LISTA DE FUNCIONARIOS
		voltarAoMenu();
	}//FIM DA LISTAGEM DE FUNCIONARIOS
	
	//REMOVER FUNCIONARIO
	public static void removerFuncionario() {
		int id;
		System.out.println(">>> REMOVENDO FUNCIONARIO <<<");
		System.out.print(">>> INSIRA O ID DO FUNCIONARIO: ");
		id = sc.nextInt();
		sc.nextLine();
		Funcionario.removeDaLista(id);
		voltarAoMenu();
	}//FIM DA REMOÇÃO DE FUNCIONARIO
	
	//METODO PARA VOLTAR AO MENU INICIAL
	public static void voltarAoMenu() {
		System.out.println(">>>PRESSIONE QUALQUER TECLA PARA VOLTAR AO MENU INICIAL<<<");
		sc.nextLine();
		menuInicial();
	}//FIM DE METODO PARA MENU INICIAL
	
//FIM DE METODOS PARA CADA FUNCIONALIDADE
}
