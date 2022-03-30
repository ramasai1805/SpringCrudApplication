package com.sai.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.sai.springboot.model.Employee;
import com.sai.springboot.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;

//	display list of employees
	@GetMapping(value = "/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", service.getAllEmployees());
		return "index";
	}

	@GetMapping(value = "/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "new_employee";
	}

	@PostMapping(value = "/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.saveEmployee(employee);
		return "redirect:/";
	}

	@GetMapping(value = "/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		Employee employee = service.getEmployeeById(id);
		model.addAttribute("employee", employee);
		return "update_employee";
	}

	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long id) {
		this.service.deleteEmployeeById(id);
		return "redirect:/";
	}

}