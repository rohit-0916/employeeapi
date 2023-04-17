package com.employee.employeeapi.controller;

import com.employee.employeeapi.exception.ResourceNotFoundException;
import com.employee.employeeapi.model.Employee;
import com.employee.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public List<Employee> getAllEmployee(){
        return employeeRepository.findAll();
    }

    @PostMapping
    public  Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee = employeeRepository.findById(id)
                        .orElseThrow(()-> new ResourceNotFoundException("employee not exist with id " +id));
        return ResponseEntity.ok(employee);
    }

    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id , @RequestBody Employee employeedetails){
        Employee updateEmployee = employeeRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("employee not exist with id "+id));
        updateEmployee.setFirstName(employeedetails.getFirstName());
        updateEmployee.setLastName(employeedetails.getLastName());
        updateEmployee.setEmailId(employeedetails.getEmailId());
        updateEmployee.setPhoneNumber(employeedetails.getPhoneNumber());


        employeeRepository.save(updateEmployee);

        return ResponseEntity.ok(updateEmployee);

    }

    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("employee not exist with id " +id));
        employeeRepository.delete(employee);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
