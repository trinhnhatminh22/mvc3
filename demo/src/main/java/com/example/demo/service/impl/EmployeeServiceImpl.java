package com.example.demo.service.impl;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {


    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getAllEmployee() {
        List<Employee> employeeList =  employeeRepository.findAll();
        return employeeList;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        Employee employeeCreated = employeeRepository.save(employee);
        return employeeCreated;
    }

    @Override
    public void deleteEmployee(Long id)  {
        if(employeeRepository.findById(id).isPresent()){
            employeeRepository.deleteById(id);
        }

    }
}
