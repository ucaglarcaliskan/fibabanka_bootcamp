package com.example.employee.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.employee.data.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	@Query("Select e from Employee as e where e.department.departmentId = :departmentId")
	public List<Employee> findByDepartmentId(@Param("departmentId") long departmentId);
}
