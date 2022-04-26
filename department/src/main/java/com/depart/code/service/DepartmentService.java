package com.depart.code.service;

import java.util.List;

import com.depart.code.entity.Department;

public interface DepartmentService {

	Department saveDepartment(Department department);

	// Read operation
	List<Department> fetchDepartmentList();
	
	Department updateDepartment(Department department, int id);
	
	// Delete operation
    void deleteDepartmentById(int departmentId);
    
    Department getDepartmentById(int id);
}
