package com.example.employee.presentation;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.employee.data.entity.Employee;
import com.example.employee.data.repository.EmployeeRepository;

@Controller
public class EmployeeController {

	private EmployeeRepository employeeRepository;

	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@GetMapping("/employees/department/{id}")
	public String findByDepartmentId(@PathVariable("id") long departmentId) {
		List<Employee> employeeList = employeeRepository.findByDepartmentId(departmentId);
		return "Çalışanlar:<br>" + employeeList;
	}
}
