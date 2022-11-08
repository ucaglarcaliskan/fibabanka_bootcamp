package com.example.demo.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.example.demo.Employee;

@Controller
public class EmployeeController {
	
	@GetMapping("/employee/get")
	@ResponseBody
	public String getEmployee() {
		long employeeId = 1;
		String url = "http://localhost:8080/api/employee/" + employeeId;
		RestTemplate restTemplate = new RestTemplate();
		Employee employee = restTemplate.getForObject(url, Employee.class);
		System.out.println("Çalışan: " + employee.getEmployeeName());
		return "Edinme Başarılı " + employee.toString();
	}
	
	@GetMapping("/employee/post")
	@ResponseBody
	public String postEmployee() {
		Employee employee = new Employee(101, "Uğur Çağlar ÇALIŞKAN", 2000);
		String url = "http://localhost:8080/api/employee";
		RestTemplate restTemplate = new RestTemplate();
		Employee result = restTemplate.postForObject(url, employee, Employee.class);
		return "Yollama başarılı " + result.getEmployeeId(); 		
	}
	
	@GetMapping("/employee/put")
	@ResponseBody
	public String putEmployee() {
		Employee employee = new Employee(102, "Muhittin", 2000);
		String url = "http://localhost:8080/api/employee";
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.exchange(url, HttpMethod.PUT, new HttpEntity<Employee>(employee), Void.class);
		return "Koyma Başarılı " + employee.getEmployeeName();
	}

	@GetMapping("/employee/delete")
	@ResponseBody
	public String deleteEmployee() {
		long employeeId = 102;
		String url = "http://localhost:8080/api/employee" + employeeId;
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(url);
		return "Silme başarılı " + employeeId; 		
	}
}
