package com.capg.empapp.db;
import java.util.ArrayList;
import java.util.List;
import com.capg.empapp.dto.Employee;

public class EmployeeDB {
	// Employee cannot be resolved to a type
	public static ArrayList<Employee> employees=new ArrayList<Employee>();
	public static ArrayList<Employee> salarys=new ArrayList<Employee>();
	public static ArrayList<Employee> salaryRange=new ArrayList<Employee>();
	
	public static int count;
	static {
		
		employees.add(new Employee(101, "ramesh", 8, 10000));
		employees.add(new Employee(102, "suresh", 2, 17000));
		employees.add(new Employee(103, "rakesh", 1, 20000));
		employees.add(new Employee(104, "lokesh", 5, 7000));
		
		}
		
		
	public static boolean addEmployee(Employee e)
	{
		
		employees.add(e);
		count=employees.size();
		return true;
	}
	
	public static int getCount()
	{
		return count;
	}
	public static boolean editExpByEmployeeId(int id,int empNewExp) {
		for(Employee employee : employees) {
			if(employee.getEmployeeId()==id) {
				employee.setExp(empNewExp);
				return true;
			}
		}
		return false;
	}
	public static boolean editSalaryByEmployeeID(int id,int empNewSalary) {
		for(Employee employee : employees) {
			if(employee.getEmployeeId()==id) {
				employee.setSalary(empNewSalary);
				return true;
			}
		}
		return false;
	}
	
	public static ArrayList<Employee> getEmployeeBySalary(int salary) {
		salarys.clear();
		for (Employee employee : employees) {
			if(employee.getSalary()==salary) {
				salarys.add(employee);
			}

		}
			return salarys;
	}
	
	public static ArrayList<Employee> getEmployessBySalaryRange(int salaryRangeMin, int salaryRangeMax) {
		salaryRange.clear();
		for (Employee employee : employees) {
			if(employee.getSalary()>=salaryRangeMin && employee.getSalary()<=salaryRangeMax) {
				salaryRange.add(employee);
				
				
			}

		}
		
		return salaryRange;
	}
}
