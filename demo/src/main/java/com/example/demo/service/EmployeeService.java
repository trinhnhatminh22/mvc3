package com.example.demo.service;

import com.example.demo.model.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAllEmployee();

    Employee createEmployee(Employee employee);

    void deleteEmployee(Long id);
}
