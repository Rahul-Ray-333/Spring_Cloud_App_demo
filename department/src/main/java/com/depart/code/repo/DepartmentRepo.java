package com.depart.code.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.depart.code.entity.Department;

public interface DepartmentRepo extends JpaRepository<Department, Integer>{

}
