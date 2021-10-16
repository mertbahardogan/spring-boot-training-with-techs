package com.mongodb.project.common.dtos;

import lombok.Data;

//TODO: karışık do içeren dto.
//TODO: ilişkisel mongo collections.
//TODO: Controller advice

@Data
public class EmployeeDTO {
    private String name;
    private String lastName;
    private int salary;
    private int age;
    private boolean isManager;
}
