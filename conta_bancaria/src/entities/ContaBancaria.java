package entities;

public class ContaBancaria {
	private String numConta;
	private String nomeCliente;
	private float saldo;
	
	public ContaBancaria(String numConta, String nomeCliente, float depositoInicial) {
		super();
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
		fazerDeposito(depositoInicial);
	}
	public ContaBancaria(String numConta, String nomeCliente) {
		this.numConta = numConta;
		this.nomeCliente = nomeCliente;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}
	
	public String getnumConta() {
		return numConta;
	}

	public float getSaldo() {
		return saldo;
	}
	
	public void fazerDeposito(float deposito) {
	     saldo+=deposito;
	     System.out.printf("\n>>>DEPOSITO REALIZADO\n>>>SALDO ATUALIZADO: %.2f\n",saldo);
	}
	
	public void fazerSaque(float saque) {
		if(saque>saldo) 
			System.out.println("SALDO INSUFICIENTE");
		else {
			saldo-=saque;
			saldo-=5;
			System.out.printf("\n>>>SAQUE REALIZADO ($ %.2f)\n",saque);
			System.out.printf(">>>TAXA DE $5 COBRADA. SALDO RESTANTE: $ %.2f\n",saldo);
		}
	}
	
	public String toString(){
		return "CONTA: "
				+this.getnumConta()
				+" , CLIENTE: "
				+this.getNomeCliente()
				+" , SALDO: "
				+String.format("%.2f",this.getSaldo());
	}
}
