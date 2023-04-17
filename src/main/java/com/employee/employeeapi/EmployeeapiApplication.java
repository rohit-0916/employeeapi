package com.employee.employeeapi;

import com.employee.employeeapi.model.Employee;
import com.employee.employeeapi.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmployeeapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeapiApplication.class, args);
	}

}
