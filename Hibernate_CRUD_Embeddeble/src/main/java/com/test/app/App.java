package com.test.app;

import com.test.entity.Country;
import com.test.entity.Employee;
import com.test.service.EmployeeService;
import com.test.service.impl.EmployeeServiceImpl;

/**
 * Hello world!
 *
 */
public class App extends Thread {

	private static EmployeeService employeeService = null;

	public App() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void run() {
		super.run();
	}

	static {
		employeeService = new EmployeeServiceImpl();
	}

	public static void main(String[] args) {
		App a = new App();

		createEmployeeStarter();
		selectAllEmployee();
//		UpdateEmployee();
//		deleteEmployee();
//		fetchSingleEmployee();

	}

	private static void createEmployeeStarter() {
		Employee[] employees = CreateEmployee();
		for (Employee e : employees) {
			employeeService.CreateEmployee(e);
			try {
				Thread.sleep(2000);
			} catch (Exception e1) {
				System.out.println(e1.getMessage());
			}
		}
	}

	private static Employee[] CreateEmployee() {

		Employee employee1 = new Employee();
		employee1.setName("John Paul");
		employee1.setAddress("England");
		employee1.setCountry(new Country("ENGLAND","WEST"));
		
		Employee employee2 = new Employee();
		employee2.setName("Raghurajan");
		employee2.setAddress("South INDIA");
		employee2.setCountry(new Country("INDIA", "EAST"));
		
		Employee employee3 = new Employee();
		employee3.setName("Team Paine");
		employee3.setAddress("AUS");
		employee3.setCountry(new Country("AUSTRELLIA", "VERY-EAST"));
		

		Employee employee4 = new Employee();
		employee4.setName("Mohammad Khan");
		employee4.setAddress("Pakistan");
		employee4.setCountry(new Country("Pakistan", "EAST"));

		Employee employee5 = new Employee();
		employee5.setName("Chris Pensen");
		employee5.setAddress("North Canada");
		employee5.setCountry(new Country("Canada", "NORTH"));
		

		Employee employee6 = new Employee();
		employee6.setName("Mohammad Kamara");
		employee6.setAddress("Bagladesh");
		employee6.setCountry(new Country("Bagladesh", "EAST"));

		Employee employee7 = new Employee();
		employee7.setName("Andrew SymondLAM");
		employee7.setAddress("FRANCE");
		employee7.setCountry(new Country("FRANCE", "WEST"));
		

		Employee[] emp = new Employee[] { employee1, employee2, employee3, employee4, employee5 ,employee6,employee7};
		
//		Employee[] emp = new Employee[] { employee6, employee7 };
		return emp;
	}

	private static void selectAllEmployee() {
		employeeService.selectAllEmployee();
	}

	private static void UpdateEmployee() {
		Employee employee = new Employee();
		employee.setId(3);
		employee.setAddress("Shree Lanka");

		employeeService.UpdateEmployee(employee);
	}

	private static void deleteEmployee() {
		employeeService.deleteEmployee(4);
	}

	private static void fetchSingleEmployee() {

		employeeService.fetchSingleEmployee(new Employee(2, "", "", null));
	}

}
