package com.example.demo.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.Employee;

public class EmployeeResource {

	@GetMapping("/api/employee/{id}")
	public Employee getEmployee(@PathVariable("id") long employeeId) {
		Employee employee = new Employee(employeeId, "Uğur Çağlar Çalışkan", 2000);
		return employee;
	}

	@GetMapping("/api/employees")
	public List<Employee> getEmployees() {
		List<Employee> employeeList = new ArrayList<>();
		employeeList.add(new Employee(101, "Uğur Çağlar Çalışkan", 2000));
		employeeList.add(new Employee(102, "Muhittin", 2000));
		return employeeList;
	}

	@PostMapping("/api/employee")
	public Employee postEmployee(@RequestBody Employee employee) {
		employee.setEmployeeId(103);
		System.out.println("Çalışan eklendi " + employee.getEmployeeId() + " " + employee.getEmployeeName() + " "
				+ employee.getMonthlySalary());
		return employee;
	}

	@PutMapping("/api/employee")
	public void putEmployee(@RequestBody Employee employee) {
		System.out.println("Çalışan güncellendi " + employee.getEmployeeId() + " " + employee.getEmployeeName() + " "
				+ employee.getMonthlySalary());
	}

	@DeleteMapping("/api/employee/{id}")
	public void deleteEmployee(@PathVariable("id") long employeeId) {
		System.out.println("Çalışan silindi " + employeeId);
	}
}
