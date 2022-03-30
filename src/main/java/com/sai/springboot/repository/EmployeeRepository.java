package com.sai.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sai.springboot.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
