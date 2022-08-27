package com.example.demo.dtos;

import lombok.*;

import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String fullname;
    private Date description;
    private Long countEmployee;
}
