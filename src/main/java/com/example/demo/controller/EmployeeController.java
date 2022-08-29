package com.example.demo.controller;

import com.example.demo.dtos.EmployeeDTO;
import com.example.demo.dtos.EmployeeDepartmentPair;
import com.example.demo.services.serviceImpl.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//{
//        "name": "test3",
//        "gender":"male",
//        "departmentId": 1
//}
@RestController
@RequestMapping(value="/api/v1/employee")
public class EmployeeController {
    @Autowired
    EmployeeServiceImpl employeeService;


    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("id") Long id)
    {
        return new ResponseEntity<>(employeeService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.save(employeeDTO),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable("id") Long id, @RequestBody EmployeeDTO employeeDTO){
        employeeDTO.setId(id);
        return new ResponseEntity<>(employeeService.update(employeeDTO),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable("id") Long id){
        return new ResponseEntity<>(employeeService.deleteById(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/getDepartment")
    public ResponseEntity<EmployeeDepartmentPair> getEmployeeAndItsDepartment(@PathVariable("id") Long id) {
        return new ResponseEntity<>(employeeService.getEmployeeAndItsDepartmentByEmployeeId(id),HttpStatus.OK);
    }
}
