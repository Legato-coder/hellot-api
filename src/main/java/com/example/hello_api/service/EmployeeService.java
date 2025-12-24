package com.example.hello_api.service;

import com.example.hello_api.exception.EmployeeNotFoundException;
import com.example.hello_api.model.Employee;
import com.example.hello_api.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    // CREATE
    public Employee createEmployee(Employee employee) {
        return repository.save(employee);
    }

    // READ ALL
    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    // READ BY ID
    public Employee getEmployeeByIdOrThrow(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new EmployeeNotFoundException("Employee not found with id: " + id));
    }

    // UPDATE
    public Employee updateEmployeeOrThrow(Long id, Employee updatedEmployee) {
        Employee existing = getEmployeeByIdOrThrow(id);

        existing.setName(updatedEmployee.getName());
        existing.setDepartment(updatedEmployee.getDepartment());
        existing.setSalary(updatedEmployee.getSalary());
        existing.setCity(updatedEmployee.getCity());

        return repository.save(existing);
    }

    // DELETE
    public void deleteEmployeeOrThrow(Long id) {
        Employee employee = getEmployeeByIdOrThrow(id);
        repository.delete(employee);
    }
}
