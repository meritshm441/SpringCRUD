package edu.employeCrud.empCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.employeCrud.empCRUD.entity.Employee;
import edu.employeCrud.empCRUD.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	EmployeeService empService;

	@Autowired
	public EmployeeController(EmployeeService empService) {
		super();
		this.empService = empService;
	}

	// http://localhost:8080/api/employees
	@GetMapping("/employees")
	List<Employee> getEMpList() {
		return empService.getEmps();
	}

}
