package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="employee")
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    @Column(name="employeeId")
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="birthDate")
    private Date birthDate;

    @Column(name="gender")
        private String gender;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departmentId", referencedColumnName = "departmentId",nullable = false)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    @JsonIgnore
    private Department department;
}
