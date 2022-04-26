package com.emp.code.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.emp.code.entity.Employee;
import com.emp.code.feignCilent.DepartmentFeignClient;
import com.emp.code.model.Department;
import com.emp.code.model.EmployeeWithDepartment;
import com.emp.code.repo.EmployeeRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private CommonService commonService;

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private WebClient webClient;

	@Autowired
	private DepartmentFeignClient departmentFeignClient;

	Logger logger = LoggerFactory.getLogger(EmployeeServiceImpl.class);

	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepo.save(employee);
	}

	@Override
	public Employee getEmployeeByID(int id) {

		Optional<Employee> emplOptional = employeeRepo.findById(id);
		return emplOptional.get();
	}

	@Override
	public EmployeeWithDepartment getEmployeeWithDepartment(int empId, int departmentCode) {

		EmployeeWithDepartment employeeWithDepartment = new EmployeeWithDepartment();

		employeeWithDepartment.setEmployee(null/* getEmployeeByID(empId) */);

		employeeWithDepartment.setDepartment(commonService.getDepartmentByID(departmentCode));
		logger.info("Inside Employee");
		return employeeWithDepartment;
	}

	/*
	 * @Override
	 * 
	 * @CircuitBreaker(name = "departmentService", fallbackMethod =
	 * "fallBackForGetDepartmentByID") public Department getDepartmentByID(int id) {
	 * 
	 * // calling department API suing web flux or webclient
	 * 
	 * Mono<Department> depMono = webClient.get().uri("/department/" +
	 * id).retrieve().bodyToMono(Department.class); return depMono.block();
	 * 
	 * return departmentFeignClient.getDepartment(id); }
	 * 
	 * public Department fallBackForGetDepartmentByID(int id) { return null; }
	 */

}
