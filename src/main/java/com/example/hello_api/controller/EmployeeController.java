package com.example.hello_api.controller;

import com.example.hello_api.dto.ApiResponse;
import com.example.hello_api.model.Employee;
import com.example.hello_api.service.EmployeeService;
import com.example.hello_api.util.EchoTokenUtil;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ApiResponse<Employee>> createEmployee(
            @RequestBody Employee employee,
            HttpServletRequest request) {

        Employee created = employeeService.createEmployee(employee);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        EchoTokenUtil.getEchoToken(request),
                        created,
                        "Employee created successfully"
                ));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<ApiResponse<List<Employee>>> getAllEmployees(
            HttpServletRequest request) {

        return ResponseEntity.ok(
                new ApiResponse<>(
                        EchoTokenUtil.getEchoToken(request),
                        employeeService.getAllEmployees(),
                        "Employees fetched successfully"
                ));
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> getEmployeeById(
            @PathVariable Long id,
            HttpServletRequest request) {

        Employee employee = employeeService.getEmployeeByIdOrThrow(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        EchoTokenUtil.getEchoToken(request),
                        employee,
                        "Employee fetched successfully"
                ));
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Employee>> updateEmployee(
            @PathVariable Long id,
            @RequestBody Employee employee,
            HttpServletRequest request) {

        Employee updated = employeeService.updateEmployeeOrThrow(id, employee);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        EchoTokenUtil.getEchoToken(request),
                        updated,
                        "Employee updated successfully"
                ));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> deleteEmployee(
            @PathVariable Long id,
            HttpServletRequest request) {

        employeeService.deleteEmployeeOrThrow(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        EchoTokenUtil.getEchoToken(request),
                        null,
                        "Employee deleted successfully"
                ));
    }
}
