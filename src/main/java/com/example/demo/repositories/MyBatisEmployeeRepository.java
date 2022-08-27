package com.example.demo.repositories;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisEmployeeRepository {
    @Select("SELECT * FROM employee WHERE employeeId=#{id}")
    Employee findEmployeeById(Long id);
}
