package com.example.demo.repositories;

import com.example.demo.dtos.EmployeeDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisEmployeeRepository {
    @Select("SELECT * FROM employee WHERE EMPLOYEE_ID=#{id}")
    @Results(value={@Result(property = "id",column = "EMPLOYEE_ID"),
                    @Result(property = "name",column="NAME"),
                    @Result(property = "birthDate",column="BIRTH_DATE"),
                    @Result(property = "gender",column="GENDER"),
                    @Result(property = "departmentId",column="DEPARTMENT_ID")}
    )
    EmployeeDTO findEmployeeById(Long id);
}
