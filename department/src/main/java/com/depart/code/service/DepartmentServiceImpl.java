package com.depart.code.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.depart.code.entity.Department;
import com.depart.code.repo.DepartmentRepo;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepo departmentRepo;

	Logger logger = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Override
	public Department saveDepartment(Department department) {
		logger.info(" Department Value to Save : " + department.getDepartmentId() + " name:"
				+ department.getDepartmentName());
		return departmentRepo.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		logger.info("Inside fetch Department List");
		return (List<Department>) departmentRepo.findAll();
	}

	@Override
	public Department updateDepartment(Department department, int id) {
		logger.info("");
		Department department2 = departmentRepo.getById(id);

		if (Objects.nonNull(department.getDepartmentName()) && !"".equalsIgnoreCase(department.getDepartmentName())) {
			department2.setDepartmentName(department.getDepartmentName());
		}
		if (Objects.nonNull(department.getDepartmentAddress())
				&& !"".equalsIgnoreCase(department.getDepartmentAddress())) {
			department2.setDepartmentAddress(department.getDepartmentAddress());
		}
		if (Objects.nonNull(department.getDepartmentCode()) && !"".equalsIgnoreCase(department.getDepartmentCode())) {
			department2.setDepartmentCode(department.getDepartmentCode());
		}
		return departmentRepo.save(department2);

	}

	@Override
	public void deleteDepartmentById(int departmentId) {

		departmentRepo.deleteById(departmentId);
		logger.info("Id : " + departmentId + " deleted successfully");
	}

	@Override
	public Department getDepartmentById(int id) {
		logger.info("Id : " + id + " get successfully");
		Optional<Department> depOptional = departmentRepo.findById(id);
		return depOptional.get();
	}

}
