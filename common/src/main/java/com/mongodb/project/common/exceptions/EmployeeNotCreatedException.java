package com.mongodb.project.common.exceptions;

public class EmployeeNotCreatedException extends Exception{

    private final String name;

    public static EmployeeNotCreatedException createWith(String name) {
        return new EmployeeNotCreatedException(name);
    }

    private EmployeeNotCreatedException(String name) {
        this.name= name;
    }

    public String getMessage() {
        return "Employee Name'" + name + "' already exists";
    }
}
