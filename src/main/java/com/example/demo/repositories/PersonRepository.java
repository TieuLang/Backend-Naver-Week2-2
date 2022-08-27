package com.example.demo.repositories;

import com.example.demo.entity.Department;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonRepository {
    @Select("select count(1) from PERSON")
    int count();

    @Select("select * from PERSON")
    List<Department> t();

    @Select("SELECT * FROM PERSON WHERE id=#{id}")
    @Results(value = {@Result(property = "id", column = "id"),
            @Result(property = "fullName", column = "fullName"),
            @Result(property = "dateOfBirth", column = "dateOfBirth")}
    )
    Department findById(long id);

    @Delete("DELETE FROM PERSON WHERE id=#{id}")
    int deleteById(long id);

    @Insert("INSERT INTO PERSON (fullName,dateOfBirth)" +
        "VALUES (#{fullName},#{dateOfBirth})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(Department person);

    @Update("Update PERSON set fullName=#{fullName} where id=#{id}")
    int update(Department person);
}
