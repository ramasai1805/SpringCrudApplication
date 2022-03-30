package com.sai.springboot.service;

import java.util.List;

import com.sai.springboot.model.Employee;

public interface EmployeeService {
	List<Employee> getAllEmployees();

	void saveEmployee(Employee employee);

	Employee getEmployeeById(Long id);

	void deleteEmployeeById(Long id);
}
