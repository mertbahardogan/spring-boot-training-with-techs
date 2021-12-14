package com.mongodb.project.common.dtos;

import lombok.Data;
import javax.validation.constraints.*;

@Data
public class EmployeeDTO {

    @NotBlank(message = "Required")
    @Size(min = 2, max = 10, message = "Name field '${validatedValue}' must be between {min} and {max} characters long")
    private String name;

    @NotBlank(message = "Required")
    private String lastName;


    @Min(value = 1, message = "'${validatedValue}' must be upper than {value}")
    private int salary;

    @Min(value = 18, message = "'${validatedValue}' must be upper than {value}")
    @Max(value = 65, message = "'${validatedValue}' must be lower than {value}")
    private int age;

    @NotNull(message = "Required")
    private boolean isManager;
}
