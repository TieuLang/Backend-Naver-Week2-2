package com.example.demo.services.serviceImpl;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.EmployeeDepartmentPair;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repositories.EmployeeRepository;
import com.example.demo.repositories.MyBatisDepartmentRepository;
import com.example.demo.repositories.MyBatisEmployeeRepository;
import com.example.demo.services.IEmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    ModelMapper modelMapper;

    @Resource
    MyBatisEmployeeRepository myBatisEmployeeRepository;

    @Resource
    MyBatisDepartmentRepository myBatisDepartmentRepository;

    @Override
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id){
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public EmployeeDTO save(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDTO,Employee.class)),EmployeeDTO.class);
    }

    @Override
    public EmployeeDTO update(EmployeeDTO employeeDTO){
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDTO,Employee.class)),EmployeeDTO.class);
    }

    @Override
    public boolean deleteById(Long id)
    {
        try{
            employeeRepository.deleteById(id);
        } catch (Exception e)
        {
            return false;
        }
        return true;
    }

    @Override
    public EmployeeDepartmentPair getEmployeeAndItsDepartmentByEmployeeId(Long id){
        EmployeeDTO employeeDTO=modelMapper.map(myBatisEmployeeRepository.findEmployeeById(id),EmployeeDTO.class);
        Department department=myBatisDepartmentRepository.findDepartmentById(employeeDTO.getDepartmentId());
        EmployeeDepartmentPair employeeDTODepartmentPair = new EmployeeDepartmentPair(employeeDTO,department);
        return employeeDTODepartmentPair;
    }
}
