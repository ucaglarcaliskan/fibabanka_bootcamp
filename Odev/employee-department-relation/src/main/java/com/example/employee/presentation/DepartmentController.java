package com.example.employee.presentation;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.employee.data.entity.Department;
import com.example.employee.data.entity.Employee;
import com.example.employee.data.repository.DepartmentRepository;

@Controller
public class DepartmentController {

	private DepartmentRepository departmentRepository;

	public DepartmentController(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	@GetMapping("/department/insert")
	@ResponseBody
	public String insert() {
		Department department = new Department(0, "Yazılım");
		department.setEmployeeList(new ArrayList<>());

		Employee employee1 = new Employee(0, "Uğur Çağlar Çalışkan", 2000);
		employee1.setDepartment(department);
		department.getEmployeeList().add(employee1);

		Employee employee2 = new Employee(0, "Muhittin", 1200);
		employee2.setDepartment(department);
		department.getEmployeeList().add(employee2);
		departmentRepository.save(department);

		return "Inserted: " + department.getDepartmentId();
	}

}
