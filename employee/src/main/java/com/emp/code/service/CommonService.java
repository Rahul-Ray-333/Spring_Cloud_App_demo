package com.emp.code.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.code.feignCilent.DepartmentFeignClient;
import com.emp.code.model.Department;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CommonService {

	@Autowired
	private DepartmentFeignClient departmentFeignClient;

	@CircuitBreaker(name = "departmentService", fallbackMethod = "fallBackForGetDepartmentByID")
	public Department getDepartmentByID(int id) {

		// calling department API suing web flux or webclient
		/*
		 * Mono<Department> depMono = webClient.get().uri("/department/" +
		 * id).retrieve().bodyToMono(Department.class); return depMono.block();
		 */
		return departmentFeignClient.getDepartment(id);
	}

	public Department fallBackForGetDepartmentByID(int id, Throwable th) {
		return null;
	}
}
