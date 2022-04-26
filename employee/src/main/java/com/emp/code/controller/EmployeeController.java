package com.emp.code.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.code.entity.Employee;
import com.emp.code.model.EmployeeWithDepartment;
import com.emp.code.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.saveEmployee(employee);
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable("id") int id) {
		return employeeService.getEmployeeByID(id);
	}

	@GetMapping("/empdep/{id}/{depid}")
	public EmployeeWithDepartment getEmployeeWithDepartment(@PathVariable("id") int id,
			@PathVariable("depid") int depid) {
		return employeeService.getEmployeeWithDepartment(id, depid);

	}
}
