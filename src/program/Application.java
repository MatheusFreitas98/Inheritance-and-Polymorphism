package program;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Application {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Employee employee = new Employee();
		List<Employee> employeeList = new ArrayList<>();
		
		Double additionalCharge;
		
		System.out.print("Enter the numbers of employees: ");
		Integer toBeRegistred = scan.nextInt();
		
		for (int i=0; i<toBeRegistred; i++) {
			System.out.print("Employee #" + (i+1) + " data: \n"
					+ "Outsourced (y/n)? ");
			String outsourced = scan.next();
			
			System.out.print("Name: ");			
			String name = scan.next();
			
			System.out.print("Hours: ");
			Integer hours = scan.nextInt();
			
			System.out.print("Value per hour: ");
			Double valuePerHour = scan.nextDouble();
			
			if (outsourced.equals("y")) {
				System.out.print("Additional charge: ");
				additionalCharge = scan.nextDouble();
				employee = new OutsourcedEmployee(name, hours, valuePerHour, additionalCharge);
				employeeList.add(employee);
				
			}
			
			else{
				employee = new Employee(name, hours, valuePerHour);
				employeeList.add(employee);
				}
			
			System.out.println();
		}
		
		System.out.println("PAYMENTS: ");
		
		for (Employee emp: employeeList) {
			if (emp instanceof OutsourcedEmployee){
				System.out.print("Outsourced employee: ");
				OutsourcedEmployee outsourced = (OutsourcedEmployee)emp;
				System.out.println(outsourced.getName() + " - $ " + outsourced.payment());				
			}
			else if (emp instanceof Employee) {
				System.out.print("Internal employee: ");
				System.out.println(emp.getName() + " - $ " + emp.payment());
			}
		}
		
		scan.close();
	}

}
