package com.example.demo.repositories;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisDepartmentRepository {
    @Select("SELECT count(EMPLOYEE.employeeId) FROM employee WHERE EMPLOYEE.employeeId=#{id}")
    int countEmployee(Long id);

    @Select("SELECT * FROM department WHERE id=#{id}")
    Department findDepartmentById(Long id);
}
