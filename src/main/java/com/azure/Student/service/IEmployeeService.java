package com.azure.Student.service;

import com.azure.Student.entity.Employee;

import java.util.List;

public interface IEmployeeService {

    List<Employee> saveEmployees(List<Employee> employees);
    List<Employee> getEmployees();
}
