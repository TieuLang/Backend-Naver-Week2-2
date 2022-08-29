package com.example.demo.repositories;

import com.example.demo.dtos.DepartmentDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface MyBatisDepartmentRepository {

   @Select("SELECT department.DEPARTMENT_ID,department.dept_name,department.description,COUNT(employee.EMPLOYEE_ID) as countEmployee FROM department,employee WHERE department.DEPARTMENT_ID=#{id} AND department.DEPARTMENT_ID=employee.DEPARTMENT_ID GROUP BY department.DEPARTMENT_ID")
    @Results(value={@Result(property = "id", column = "DEPARTMENT_ID"),
            @Result(property = "fullname", column = "dept_name"),
            @Result(property = "description", column = "description"),
            @Result(property = "countEmployee", column = "countEmployee")}
    )
    DepartmentDTO findDepartmentById(Long id);
}
