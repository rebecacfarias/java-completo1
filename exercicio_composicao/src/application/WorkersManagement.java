package application;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.enums.*;
import entities.*;

/*
 	IMPLEMENTAR CLASSES RESTANTES
 	AJUSTAR SWITCH OP DO MAIN 
 	TESTAR
 */



public class WorkersManagement {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		while(true) {
			Scanner sc = new Scanner(System.in);
			int op = mainMenu(sc);
			if(op == 8)
				break;
			if(op == 2 && Department.listOfDepartments.isEmpty()) {
				System.out.println("REGISTER A DEPARTMENT BEFORE REGISTERING ANY WORKERS.");
				op = mainMenu(sc);
			}
			switch(op) {
		 	  case 1: registerDepartment(sc);break;
		 	  case 2: registerWorker(sc);break;
		 	  case 3: registerContract(sc,null);break;
		 	  case 4: seeWorkersList();break;
		 	  case 5: HourContract.showAllContracts();break;
		 	  case 6: removeDepartment(sc);break;
		 	  case 7: removeWorker(sc);
			}
		}
		

	}
	public static int mainMenu(Scanner sc){
		int op;
		System.out.println("1. REGISTER DEPARTMENT");
		System.out.println("2. REGISTER WORKER ");
		System.out.println("3. REGISTER CONTRACT ");
		System.out.println("4. SEE WORKERS LIST");
		System.out.println("5. SEE CONTRACTS LIST");
		System.out.println("6. REMOVE DEPARTMENT");
		System.out.println("7. REMOVE WORKER");
		System.out.println("8. CLOSE");
		do {
			System.out.print("(type 1, 2, 3, 4, 5, 6, 7 or 8)>>> ");
			op = sc.nextInt();
		}while(op>8 || op<1);
		sc.nextLine();
		
		return op;
	}
	
	public static void registerDepartment(Scanner sc) {
	  char op;
	  String name;
	  do {
		separateThings("REGISTERING DEPARTMENT");
		System.out.print("DPT NAME: ");
		name = sc.nextLine().toUpperCase();
		

		if(!Department.departmentAlreadyRegistered(name)) {
			Department dpt = new Department(name);
			Department.addDepartmentToList(dpt);
			System.out.println("REGISTERED SUCCESSFULLY");
		}else {
			System.out.println("DEPARTMENT ALREADY EXISTS.");
		}
		System.out.print("REGISTER ANOTHER DEPARTMENT? (S,N) >>> ");
		op = sc.next().charAt(0);
		sc.nextLine();
		op = Character.toUpperCase(op);
	  }while(op=='S');
		
	}
	
	public static void registerWorker(Scanner sc) {
		  char op;
		  String name,cpf,departmentName,workLevel;
		  double baseSalary;
		  Department department = null;
		  Worker worker = null;
		  
		  do {
			separateThings("REGISTERING WORKER");
			System.out.print("CPF: ");
			cpf = sc.nextLine();
			if(!Worker.cpfAlreadyRegistered(cpf)) {
				System.out.print("WORKER NAME: ");
				name = sc.nextLine().toUpperCase();
				System.out.print("DEPARTMENT NAME: ");
				departmentName = sc.nextLine().toUpperCase();
				if(Department.departmentAlreadyRegistered(departmentName)) {
					for(Department dpt : Department.listOfDepartments) {
						if(dpt.getName().intern() == departmentName.intern()) {
							department = dpt;
							break;
						}
					}
					System.out.println("WORKER LEVEL: (JUNIOR, MID_LEVEL, SENIOR) ");
					do {
					 System.out.print("(type here)>>> ");
					 workLevel = sc.nextLine().toUpperCase();
					}while(workLevel.intern() != "JUNIOR" && workLevel.intern() != "MID_LEVEL" && workLevel.intern() != "SENIOR");
					switch(workLevel.intern()) {
						case "JUNIOR": baseSalary = 2000.00;break;
						case "MID_LEVEL": baseSalary = 4000.00;break;
						case "SENIOR": baseSalary = 8000.00;break;
						default: baseSalary = 1000;
					}
					worker = new Worker(name,cpf,department,WorkerLevel.valueOf(workLevel),baseSalary);
					Worker.addWorker(worker);
					registerContract(sc,worker);
					
				}else {
					System.out.println("DEPARTMENT DOESN'T EXIST.");
				}
				
			}else {
				System.out.println("CPF ALREADY REGISTERED.");
			}
			System.out.print("REGISTER ANOTHER WORKER? (S,N) >>> ");
			op = sc.next().charAt(0);
			sc.nextLine();
			op = Character.toUpperCase(op);
		  }while(op=='S');
	}
	
	public static void registerContract(Scanner sc, Worker worker) {
		char op;
		String cpf;
		Date date = new Date();
		double valuePerHour;
		int hours;
		Worker auxWorker = null;
		boolean keepGoing = true;
		do {
			separateThings("REGISTERING CONTRACT");
			if(worker == null) {
				System.out.print("WORKER CPF: ");
				cpf = sc.nextLine();
				if(Worker.cpfAlreadyRegistered(cpf)) {
					for(Worker w : Worker.workersList) {
						if(w.getCpf().intern()==cpf.intern()) {
							auxWorker = w;
							break;
						}
					}
				}else{
					System.out.println("CPF NOT REGISTERED.");
					keepGoing = false;
				}
			}else {
				auxWorker = worker;
			}
			if(keepGoing) {
				System.out.print("VALUE PER HOUR: ");
				valuePerHour = sc.nextDouble();
				sc.nextLine();
				System.out.print("HOURS PER MONTH: ");
				hours = sc.nextInt();
				sc.nextLine();
				HourContract contract = new HourContract(auxWorker,date,valuePerHour,hours);
				auxWorker.addContract(contract);
			}
			
			System.out.print("REGISTER ANOTHER CONTRACT? (S,N) >>> ");
			op = sc.next().charAt(0);
			sc.nextLine();
			op = Character.toUpperCase(op);
		}while(op=='S');
		
	}
	
	public static void seeWorkersList() {
		if(!Worker.workersList.isEmpty()) {
			for(Worker w : Worker.workersList) {
				System.out.println(w.toString());
				w.showWorkersContracts();
			}
		}else {
			System.out.println("NO WORKERS REGISTERED.");
		}
	}
	
	
	
	public static void removeDepartment(Scanner sc) {
		System.out.print("DEPARTMENT NAME: ");
		String dpt = sc.nextLine().toUpperCase();
		Department.removeDepartmentFromList(dpt);
		
	}
	public static void removeWorker(Scanner sc) {
		System.out.println("WORKER CPF: ");
		String cpf = sc.nextLine();
		Worker.removeWorker(cpf);
	}
	
	public static void separateThings(String sectionName) {
		System.out.println("_____________________________________");
		System.out.println(">>>>>> "+sectionName+" <<<<<<");
	}
	

}
