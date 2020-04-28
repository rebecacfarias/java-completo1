package entities;

import java.util.ArrayList;
import java.util.List;

public class Department {
	private String name;
	public static List<Department> listOfDepartments = new ArrayList<>();
	private List<Worker> listOfDepartmentWorkers = new ArrayList<>();
	
	public Department(String name) {
		setName(name);
	}
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name.toUpperCase();
	}
	
	public String toString() {
		return this.name;
	}
	
	public static void addDepartmentToList(Department department) {
		listOfDepartments.add(department);
	}
	
	public static void removeDepartmentFromList(String name){
		boolean dptWasFound = false;
		if(!listOfDepartments.isEmpty()) {
			for(Department dpt : listOfDepartments) {
				if(dpt.getName().intern()==name.toUpperCase().intern()) {
					if(!dpt.listOfDepartmentWorkers.isEmpty()) {
						System.out.println("WORKERS OF REMOVED DPT: ");
						for(Worker w : dpt.listOfDepartmentWorkers) {
							w.setDepartment(new Department(">current department was removed<"));
							w.toString();
						}
					}
					listOfDepartments.remove(dpt);
					dptWasFound = true;
					break;
				}
			}//fim do for principal
			if(dptWasFound) {
				System.out.println("DEPARTMENT REMOVED SUCCESSFULLY.");
			}else {
				System.out.println("DEPARTMENT NOT FOUND");
			}
		}
	}
	
	public void addWorkerToDepartment(Worker worker) {
		this.listOfDepartmentWorkers.add(worker);
	}
	public void removeWorkerFromDepartment(Worker worker) {
		worker.setDepartment(new Department("> currently undefined <"));
		this.listOfDepartmentWorkers.remove(worker);
	}
	
	public static boolean departmentAlreadyRegistered(String name) {
		//if(!Department.listOfDepartments.isEmpty()) {
			for(Department dpt : Department.listOfDepartments) {
				if(dpt.getName().intern() == name.intern()) {
					return true;
				}
			}
		
		return false;
	}
	
}
