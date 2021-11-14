package com.mongodb.project.common.dtos;

import lombok.Data;

@Data
public class EmployeeDTO {
    private String name;
    private String lastName;
    private int salary;
    private int age;
    private boolean isManager;
}
