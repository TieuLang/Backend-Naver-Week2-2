package com.example.demo.services.serviceImpl;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.repositories.DepartmentRepository;
import com.example.demo.repositories.MyBatisDepartmentRepository;
import com.example.demo.services.IDepartmentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DepartmentServiceImpl implements IDepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    @Resource
    MyBatisDepartmentRepository myBatisDepartmentRepository;

    @Autowired
    ModelMapper modelMapper;


    @Override
    public List<Department> getAllDepartment(){
        return departmentRepository.findAll();
    }

    @Override
    public Department getDepartmentById(Long id){
        Department department=departmentRepository.findById(id).orElse(null);
        if (department!=null)
        {
            department.setEmployees(department.getEmployees());
            return department;
        };
        return null;
    }

    @Override
    public Department save(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public Department update(Department department){
        return departmentRepository.save(department);
    }

    @Override
    public boolean deleteById(Long id){
        try{
            departmentRepository.deleteById(id);
        } catch ( Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public DepartmentDTO getDepartmentWithCountEmployee(Long id){
        DepartmentDTO departmentDTO=modelMapper.map(departmentRepository.findById(id), DepartmentDTO.class);
        departmentDTO.setCountEmployee((long)myBatisDepartmentRepository.countEmployee(id));
        return departmentDTO;
    }
}
