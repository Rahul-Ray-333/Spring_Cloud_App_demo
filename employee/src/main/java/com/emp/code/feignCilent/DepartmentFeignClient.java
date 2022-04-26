package com.emp.code.feignCilent;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.emp.code.model.Department;

/*@FeignClient(url = "${department.service.url}", value = "department-feign-client", path = "/department")
public interface DepartmentFeignClient {

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") int id);

}*/

//second way using eureka server 
@FeignClient(value = "DEPARTMENT-SERVICE", path = "/department")
public interface DepartmentFeignClient {

	@GetMapping("/{id}")
	public Department getDepartment(@PathVariable("id") int id);

}
/*
 * @FeignClient(value = "api-gateway/DEPARTMENT-SERVICE") public interface
 * DepartmentFeignClient {
 * 
 * @GetMapping("/department/{id}") public Department
 * getDepartment(@PathVariable("id") int id);
 * 
 * }
 */
