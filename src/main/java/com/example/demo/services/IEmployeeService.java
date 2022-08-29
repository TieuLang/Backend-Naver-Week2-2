package com.example.demo.services;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.EmployeeDepartmentPair;

import java.util.List;

public interface IEmployeeService {
    List<EmployeeDTO> getAll();

    EmployeeDTO getById(Long id);

    EmployeeDTO save(EmployeeDTO employeeDTO);

    EmployeeDTO update(EmployeeDTO employeeDTO);

    boolean deleteById(Long id);

    EmployeeDepartmentPair getEmployeeAndItsDepartmentByEmployeeId(Long id);
}
