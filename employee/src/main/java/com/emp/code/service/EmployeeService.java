package com.emp.code.service;

import com.emp.code.entity.Employee;
import com.emp.code.model.Department;
import com.emp.code.model.EmployeeWithDepartment;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	
	Employee getEmployeeByID(int id);
	
	EmployeeWithDepartment getEmployeeWithDepartment(int empId, int departmentCode);
	
	//public Department getDepartmentByID(int id);
}
