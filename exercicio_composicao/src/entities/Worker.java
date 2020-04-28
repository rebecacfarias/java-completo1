package entities;
import java.util.ArrayList;
import java.util.List;
import entities.enums.WorkerLevel;

public class Worker {
	private String name;
	private String cpf;
	private Department department;
	private WorkerLevel level;
	private double baseSalary;
	private List<HourContract> listOfHourContracts = new ArrayList<>();
	public static List<Worker> workersList = new ArrayList<>();
	
	public Worker(String name, String cpf,Department department, WorkerLevel level, double baseSalary) {
		this.name = name;
		this.cpf = cpf;
		this.department = department;
		this.level = level;
		this.baseSalary = baseSalary;
	}
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public Department getDepartment() {
		return this.department;
	}
	public void setDepartment(Department department) {
		this.department = department;
	}
	public WorkerLevel getLevel() {
		return level;
	}
	public void setLevel(WorkerLevel level) {
		this.level = level;
	}
	public double getBaseSalary() {
		return baseSalary;
	}
	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}
	//FAZER
	public String toString(){
		return String.format("\n NAME: %s \n CPF: %s \n DEPARTMENT: %s \n ",this.getName(),this.getCpf(),this.getDepartment().toString())
			   +"LEVEL: "+this.getLevel()
			   +String.format("\n BASE SALARY: $%.2f", this.getBaseSalary());
	}
	
	//funcoes da lista de contratos do funcionario  e geral
	public void addContract(HourContract contract) { 
		this.listOfHourContracts.add(contract);
		HourContract.listOfAllContracts.add(contract);
	}
	
	//remover contrato: checa lista de contratos, remove pelo ID da lista do objeto e da lista dos contratos
	
	public void removeContract(int id) {
		boolean idWasFound = false;
		for(HourContract hc : this.listOfHourContracts) {
		    if(hc.getId()==id) {
		    	this.listOfHourContracts.remove(hc);
		    	HourContract.listOfAllContracts.remove(hc);
		    	idWasFound = true;
		    	break;
		    }
		}
		
		if(!idWasFound) {
			System.out.println("ID DOESN'T EXIST.");
			//pode perguntar se quer digitar id de novo ou sair
		}
	}
	
	
	//funcoes da lista de funcionarios...
	
	public static void addWorker(Worker worker) {
		Worker.workersList.add(worker);
		worker.getDepartment().addWorkerToDepartment(worker);
	}
	public static void removeWorker(String cpf) {
		boolean cpfWasFound = false;
		if(!workersList.isEmpty()) {
			for(Worker worker : workersList) {
				if(worker.getCpf().intern() == cpf.intern()) {
					worker.getDepartment().removeWorkerFromDepartment(worker);
					workersList.remove(worker);
					cpfWasFound = true;
					System.out.println("WORKER REMOVED SUCCESSFULLY");
					break;
				}
			}
			if(!cpfWasFound){
				System.out.println("COULD NOT FIND WORKER");
			}
		}
	}
	
	
	public static boolean cpfAlreadyRegistered(String cpf) {
		boolean cpfWasFound = false;
		if(!workersList.isEmpty()) {
			for(Worker worker : workersList) {
				if(worker.getCpf().intern() == cpf.intern()) {
					cpfWasFound = true;
					break;
				}
			}

		}
		return cpfWasFound;
	}
	
	public void showWorkersContracts() {
		System.out.println(" CONTRACTS: ");
		for(HourContract contract : this.listOfHourContracts) {
			System.out.println("-");
			System.out.println(contract.toStringJustContract());
		}
	}
	
}
