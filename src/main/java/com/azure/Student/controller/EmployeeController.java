package com.azure.Student.controller;

import com.azure.Student.entity.Employee;
import com.azure.Student.service.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private IEmployeeService employeeService;

    @RequestMapping(
            value = "/api/v1/employee",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Employee>> saveEmployees(
            @RequestBody List<Employee> employees
    ){
        if(!CollectionUtils.isEmpty(employeeService.saveEmployees(employees)))
            return ResponseEntity.ok(employees);
        return ResponseEntity.ok(null);
    }

    @RequestMapping(
            value = "/api/v1/employee",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<List<Employee>> getEmployees(){
        return ResponseEntity.ok(employeeService.getEmployees());
    }


}
