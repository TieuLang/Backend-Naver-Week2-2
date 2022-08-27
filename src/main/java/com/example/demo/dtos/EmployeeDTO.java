package com.example.demo.dtos;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String name;
    private Date birthDate;
    private String gender;
    private Long departmentId;
}
