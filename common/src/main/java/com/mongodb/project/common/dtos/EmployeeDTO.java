package com.mongodb.project.common.dtos;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Bu alan zorunludur.")
    private String name;

    @NotBlank(message = "Bu alan zorunludur.")
    private String lastName;

    @Min(value=1,message = "Salary cannot be lower than 1.")
    private int salary;

    @Min(value=18,message = "Age cannot be lower than 18.")
    @Max(value=65,message = "Age cannot be higher than 65.")
    private int age;

    private boolean isManager;
}
