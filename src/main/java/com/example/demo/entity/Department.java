package com.example.demo.entity;

import lombok.*;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<Employee> employees;
}
