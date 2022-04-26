package com.emp.code.model;

import com.emp.code.entity.Employee;

public class EmployeeWithDepartment {

	Employee employee;

	Department department;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public EmployeeWithDepartment(Employee employee, Department department) {
		super();
		this.employee = employee;
		this.department = department;
	}

	public EmployeeWithDepartment() {
		super();
	}

}
