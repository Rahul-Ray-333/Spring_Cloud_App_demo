package com.depart.code.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.depart.code.entity.Department;
import com.depart.code.service.DepartmentService;

@RestController
public class DepartmentController {

	@Autowired
	private DepartmentService departmentService;

	@PostMapping("/department")
	public Department saveDepartment(@RequestBody Department department) {
		return departmentService.saveDepartment(department);
	}

	@GetMapping("/department")
	public List<Department> getListOfDepartment() {
		return departmentService.fetchDepartmentList();
	}

	@GetMapping("/department/{id}")
	public Department getDepartment(@PathVariable("id") int id) {
		return departmentService.getDepartmentById(id);
	}

	@PutMapping("/department/{id}")
	public Department updateDepartment(@RequestBody Department department, @PathVariable("id") int id) {
		return departmentService.updateDepartment(department, id);
	}

	@DeleteMapping("/department/{id}")
	public String deleteDepartmendById(@PathVariable("id") int id) {
		departmentService.deleteDepartmentById(id);
		return "Deleted Successfully";

	}

}
