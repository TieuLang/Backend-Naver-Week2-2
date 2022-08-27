package com.example.demo.entity;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="department")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="departmentId")
    private Long id;

    @Column(name="dept_name")
    private String fullname;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;
}
