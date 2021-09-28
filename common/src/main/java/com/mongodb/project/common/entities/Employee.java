package com.mongodb.project.common.entities;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "employees")
public class Employee {
    @Id
    private String id;
    private String name;
    private String lastName;
    private int salary;
    private int age;
    private boolean isManager;
}
