package com.capg.empapp.db;

import com.capg.empapp.dto.Employee;

public class EmployeeDB {
	// Employee cannot be resolved to a type
	public static Employee employees[]  = new Employee[100];
	public static Employee salarys[]=new Employee[100];
	public static Employee salaryRange[]=new Employee[100];
	
	public static int count = 0;
	
	static {
		
		employees[count++] = 	new Employee(101, "ramesh", 8, 10000);
		employees[count++] = 	new Employee(102, "suresh", 2, 17000);
		employees[count++] = 	new Employee(103, "rakesh", 1, 20000);
		employees[count++] = 	new Employee(104, "lokesh", 5, 7000);
		
		}
		
		
	public static boolean addEmployee(Employee e)
	{
		
		employees[count++] = e;
	
		return true;
	}
	
	public static int getCount()
	{
		return count;
	}
	public static boolean editExpByEmployeeId(int id,int empNewExp) {
		for(int i=0;i<count;i++) {
			if(employees[i].getEmployeeId()==id) {
				employees[i].setExp(empNewExp);
				return true;
			}
		}
		return false;
	}
	public static boolean editSalaryByEmployeeID(int id,int empNewSalary) {
		for(int i=0;i<count;i++) {
			if(employees[i].getEmployeeId()==id) {
				employees[i].setSalary(empNewSalary);
				return true;
			}
		}
		return false;
	}
	
	public static Employee[] getEmployeeBySalary(int salary) {
		int j=0;
		for(int i=0;i<count;i++) {
			if(employees[i].getSalary()==salary) {
				salarys[j]=employees[i];
				j+=1;
				
			}
				
		}
		
		return salarys;
	}
	
	public static Employee[] getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		int j=0;
		for(int i=0;i<count;i++) {
			if(employees[i].getSalary()>=salaryRangeMin && employees[i].getSalary()<=salaryRangeMax)
			{
				salaryRange[j]=employees[i];
			j+=1;
			
	
			}
		}
		
		return salaryRange;
	}
}
