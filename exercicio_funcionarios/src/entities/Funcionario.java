package entities;
import java.util.ArrayList;
import java.util.List;
/*
 
 CLASSE FUNCIONARIO
 
*/

//INICIO DA CLASSE
public class Funcionario {
	//ATRIBUTOS
	private Integer id;
	private String nome;
	private Float salario;
	//ATRIBUTO ESTATICO - LISTA DE FUNCIONARIOS
	public static List<Funcionario> listaDeFuncionarios = new ArrayList<>();
	
	
	//CONSTRUTOR
	public Funcionario(Integer id, String nome, Float salario) {
		setId(id);
		setNome(nome);
		this.salario = salario;
	}
	
	
	//GETTERS E SETTERS
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
	}
	public Float getSalario() {
		return salario;
	}
	//FIM DE GETTERS E SETTERS
	
	//METODO PARA AJUSTE DE SALARIO
	public static void ajustaSalario(int id, float porcentagem) {
	   if(checaExistencia(id)) {
		for(Funcionario f : listaDeFuncionarios) {
			if(f.getId() == id) {
			   f.salario += f.getSalario()*(porcentagem/100);
			   System.out.println(">>> SALARIO AJUSTADO COM SUCESSO <<<");
			   break;
			}
		}
	   }else {
		   System.out.println(">>> ERRO - FUNCIONARIO NAO CADASTRADO <<<");
	   }
	}
	//FIM DE METODO PARA AJUSTE DE SALARIO
	
	
	//TO STRING
	public String toString() {
		return String.format("\n - ID: %d \n - NOME: %s \n - SALARIO: $%.2f",getId(),getNome(),getSalario());
	}//FIM DE TO STRING
	
	//METODO ESTATICO PARA ADICIONAR FUNCIONARIO NA LISTA
	public static void adicionaNaLista(Funcionario funcionario) {
		listaDeFuncionarios.add(funcionario);
	}//FIM DE ADI플O NA LISTA
	
	//METODO ESTATICO PARA REMOVER FUNCIONARIO DA LISTA
	public static void removeDaLista(int id) {
	   if(checaExistencia(id)) {
		for(Funcionario f : listaDeFuncionarios) {
			if(f.getId() == id) {
				listaDeFuncionarios.remove(f);
				System.out.println(">>>FUNCIONARIO REMOVIDO<<<");
				break;
			}
		}
	   }else {
		System.out.println(">>>FUNCIONARIO NAO ENCONTRADO<<<");
	   }
	}//FIM DE REMO플O DA LISTA
	
	
	//METODO ESTATICO PARA EXIBIR LISTA DE FUNCIONARIOS
	public static void exibeFuncionarios(){
		System.out.println(">>> LISTA DE FUNCIONARIOS <<<");
		if(listaDeFuncionarios.size()==0) {
			System.out.printf("\n AINDA NAO HA FUNCIONARIOS CADASTRADOS \n");
		}else {
			for(Funcionario f : listaDeFuncionarios) {
				System.out.println(f.toString());
			}
		}
	}//FIM DE METODO DE EXIBI플O
	
	//METODO ESTATICO PARA ALTERAR NOME DE FUNCIONARIO
	public static void alteraNome(int id,String novoNome) {
	   if(checaExistencia(id)) {
		for(Funcionario f : listaDeFuncionarios) {
			if(f.getId()==id) {
				f.setNome(novoNome);
				break;
			}
		}
		System.out.println(">>> NOME ATUALIZADO COM SUCESSO <<<");
	   }
	   else {
		   System.out.println("FUNCIONARIO NAO EXISTE.");
	   }
	}//FIM DE METODO DE ALTERA플O DE NOME
	
	//METODO PARA CHECAR A EXISTENCIA DE UM FUNCIONARIO PELO ID
	public static boolean checaExistencia(int id) {
		if(listaDeFuncionarios.size()>0) {
			for(Funcionario f : listaDeFuncionarios) {
				if(f.getId() == id)
					return true;
			}
		}

		return false;
	}//FIM DE METODO DE CHECAGEM
	
}//FIM DE CLASSE
	

