package com.example.demo.services;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entity.Department;

import java.util.List;

public interface IDepartmentService {
    List<Department> getAllDepartment();

    Department getDepartmentById(Long id);

    Department save(Department department);

    Department update(Department department);

    boolean deleteById(Long id);

    DepartmentDTO getDepartmentWithCountEmployee(Long id);
}
