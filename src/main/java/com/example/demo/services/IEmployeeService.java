package com.example.demo.services;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.EmployeeDepartmentPair;
import com.example.demo.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> getAll();

    Employee getById(Long id);

    EmployeeDTO save(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);

    boolean deleteById(Long id);

    EmployeeDepartmentPair getEmployeeAndItsDepartmentByEmployeeId(Long id);
}
