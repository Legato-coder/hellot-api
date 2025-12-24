package com.example.hello_api.exception;


public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(String id) {
        super("Employee not found with id: " + id);
    }
}
