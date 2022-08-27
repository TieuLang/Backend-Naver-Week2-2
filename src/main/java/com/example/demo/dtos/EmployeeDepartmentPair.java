package com.example.demo.dtos;

import com.example.demo.entity.Department;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDepartmentPair {
    private EmployeeDTO employeeDTO;
    private Department department;
}
