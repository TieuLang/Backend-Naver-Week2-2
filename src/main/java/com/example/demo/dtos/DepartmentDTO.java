package com.example.demo.dtos;

import lombok.*;


@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDTO {
    private Long id;
    private String fullname;
    private String description;
    private Long countEmployee;
}
