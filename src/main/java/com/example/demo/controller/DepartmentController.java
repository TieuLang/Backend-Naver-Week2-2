package com.example.demo.controller;

import com.example.demo.dtos.DepartmentDTO;
import com.example.demo.entity.Department;
import com.example.demo.services.serviceImpl.DepartmentServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/department")
public class DepartmentController {
    @Autowired
    DepartmentServiceImpl departmentService;

    @Autowired
    ModelMapper modelMapper;

    @GetMapping("/")
    public ResponseEntity<List<Department>> getDepartment(){
        return new ResponseEntity<>(departmentService.getAllDepartment(),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id){
        return new ResponseEntity<>(departmentService.getDepartmentById(id), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<Department> addDepartment(@RequestBody Department department){
        return new ResponseEntity<>(departmentService.save(department),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Department> updateDepartment(@PathVariable("id")  Long id, @RequestBody Department department){
        department.setId(id);
        return new ResponseEntity<>(departmentService.update(department),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteDepartment(@PathVariable("id") Long id){
        return new ResponseEntity<>(departmentService.deleteById(id),HttpStatus.OK);
    }

    @GetMapping("/{id}/countEmployee")
    public ResponseEntity<DepartmentDTO> getDepartmentWithCount(@PathVariable("id") Long id){
        return new ResponseEntity<>(departmentService.getDepartmentWithCountEmployee(id),HttpStatus.OK);
    }
}
