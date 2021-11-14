package com.mongodb.project.common.exceptions;

public class EmployeeNotFoundException extends Exception{
    private final String id;

    public static EmployeeNotFoundException createWith(String id) {
        return new EmployeeNotFoundException(id);
    }

    private EmployeeNotFoundException(String id) {
        this.id = id;
    }

    public String getMessage() {
        return "Employee ID'" + id + "' not found";
    }
}
