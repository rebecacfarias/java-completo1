package entities;

public class RegistroDeAluguel {
	
	private String nome;
	private String email;
	private int numQuarto;
	public static int[] quartos = new int[10]; //vetor estatico para controle de quartos alugados, vetor[n] recebe 1 se o quarto esta ocupado, continua em zero se desocupado;
	
	public RegistroDeAluguel(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getNumQuarto() {
		return numQuarto;
	}
	public void alugaQuarto(int num) {
			numQuarto = num;
			quartos[num] = 1;
	}
	public static void desocupaQuarto(int num,RegistroDeAluguel[] alugueis) {
		quartos[num] = 0;
		alugueis[num] = null;
	}
	
	public String toString(){
		return "Quarto: "+getNumQuarto()
		      +", Nome: "+getNome()
			  +", Email: "+getEmail();
				
	}
	public static void showRents(RegistroDeAluguel[] alugueis){
		int i,cont=0;
		for(i=0;i<alugueis.length;i++) {
			if(quartos[i] == 1) {
				System.out.printf("- %s\n",alugueis[i].toString());
				cont++;
			}

			}
		if(cont == 0) {
			System.out.println("NENHUM ALUGUEL REGISTRADO.");
		}
		System.out.println("___________________________________");
	}
	
	

}
