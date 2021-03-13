package com.capg.empapp.main;
import java.util.ArrayList;
import java.util.Scanner;

import com.capg.empapp.db.EmployeeDB;
import com.capg.empapp.dto.Employee;
import com.capg.empapp.service.EmployeeServiceImpl;
import com.capg.empapp.service.IEmployeeService;

public class EmpMainClass {
	
	IEmployeeService empService = new EmployeeServiceImpl();
	
	public static void main(String[] args) {
		
		EmpMainClass app = new EmpMainClass();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println(" === MUNU ==== ");
			System.out.println("1. add employee ");
			System.out.println("2. Display All Employee ");
			System.out.println("3. Get Employee based on salary ");
			System.out.println("4. Get Employee based on salary Range ");
			System.out.println("5. Edit Salary by Employee ID ");
			System.out.println("6. Edit Exp by Employee ID  ");
			System.out.println("0. EXIT");
			System.out.println("Enter Option");
			int option = Integer.parseInt(sc.nextLine());
			switch(option)
			{
			
			case 1:
				
				System.out.println("Enter Employee Id ");
				int empId = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Salary ");
				int empSalary = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Exp ");
				int empExp = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Name ");
				String name = sc.nextLine();
				
				Employee e = new Employee(empId, name, empExp, empSalary);
				
				try
				{
					boolean isInserted = app.empService.addEmployee(e);
					if(isInserted)
					{
						System.out.println(" Employee Added !!!");
					}
					else
					{
						 throw new Exception("Cannot added Employee ...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				
				break;
			case 2:
				
				ArrayList<Employee> arr = app.empService.getAllEmployees();
				
				for (Employee employee : arr) {
					System.out.println(employee);
					System.out.println(" ========================================================");
				}
				break;
			case 3:
				System.out.println("Enter Employee Salary ");
				int empSalary1 = Integer.parseInt(sc.nextLine());
				
				ArrayList<Employee> salarys=app.empService.getEmployeeBySalary(empSalary1);
				if(salarys.size()>0) {
				System.out.println("The Employees with salary of "+empSalary1);
				for (Employee salary:salarys) {
					System.out.println(salary);
					System.out.println(" ========================================================");
				}
				}
				else
					System.out.println("The Entered salary was not matched with any Employee's salary");
				break;
			case 4:
				System.out.println("Enter Employee Salary Min");
				int empSalarymin = Integer.parseInt(sc.nextLine());
				System.out.println("Enter Employee Salary Max");
				int empSalarymax = Integer.parseInt(sc.nextLine());
				
				
				
				ArrayList<Employee> salarysRange=app.empService.getEmployessBySalaryRange(empSalarymin, empSalarymax);
				if(salarysRange.size()>0) {
				System.out.println("The Employees with in  salary Range  of"+empSalarymin+" to "+empSalarymax);
				for (Employee salR:salarysRange) {
					System.out.println(salR);
					System.out.println(" ========================================================");
				}
				}
				else
					System.out.println("There is no salary in range ");
				break;
			case 5:
				System.out.println("Enter Employee Id ");
				int empIdToSearch = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Salary ");
				int empNewSalary = Integer.parseInt(sc.nextLine());
				
				
				
				try
				{
					boolean isChanged = app.empService.editSalaryByEmployeeId(empIdToSearch,empNewSalary);
					if(isChanged)
					{
						System.out.println(" Employee Details Updated !!!");
					}
					else
					{
						 throw new Exception("Cannot Find Employee ID...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				break;
			case 6:
				System.out.println("Enter Employee Id ");
				int empIdToSearchexp = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Employee Exp ");
				int empNewExp = Integer.parseInt(sc.nextLine());
				
				
				
				try
				{
					boolean isChanged = app.empService.editExpByEmployeeId(empIdToSearchexp,empNewExp);
					if(isChanged)
					{
						System.out.println(" Employee Details Updated !!!");
					}
					else
					{
						 throw new Exception("Cannot Find Employee ID...");
					}
				}
				catch(Exception ex)
				{
					System.out.println(" Contact to Customer Care ... "+ex); // raise the exception
				}
				break;
			case 0:
				System.exit(0);
			
			
			
			}//end switch
			
		}// end while
		
		
		
	}//end main

}//end class
