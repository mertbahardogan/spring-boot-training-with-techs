package com.mongodb.project.common.dtos;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@ApiModel(value ="Employee DTO", description ="Employee Data Transfer Object")
public class EmployeeDTO {

    @NotBlank(message = "Required")
    @Size(min = 2, max = 10, message = "Name field '${validatedValue}' must be between {min} and {max} characters long")
    @ApiModelProperty(value="Employee DTO name field.", required = true)
    private String name;

    @NotBlank(message = "Required")
    private String lastName;


    @Min(value = 1, message = "'${validatedValue}' must be upper than {value}")
    @ApiModelProperty(value="Employee DTO salary field.", required = false)
    private int salary;

    @Min(value = 18, message = "'${validatedValue}' must be upper than {value}")
    @Max(value = 65, message = "'${validatedValue}' must be lower than {value}")
    private int age;

    @NotNull(message = "Required")
    private boolean isManager;
}
