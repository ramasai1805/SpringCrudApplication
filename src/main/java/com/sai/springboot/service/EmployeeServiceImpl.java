package com.sai.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sai.springboot.model.Employee;
import com.sai.springboot.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	@Override
	public void saveEmployee(Employee employee) {
		this.repository.save(employee);
	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> optional = repository.findById(id);
		Employee employee = null;
		if (optional.isPresent()) {
			employee = optional.get();
		} else {
			throw new RuntimeException("employee not found for id " + id);
		}
		return employee;
	}

	@Override
	public void deleteEmployeeById(Long id) {
		this.repository.deleteById(id);
	}

}
