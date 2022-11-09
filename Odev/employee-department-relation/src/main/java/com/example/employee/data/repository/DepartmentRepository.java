package com.example.employee.data.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.employee.data.entity.Department;

public interface DepartmentRepository extends CrudRepository<Department, Long> {

}
