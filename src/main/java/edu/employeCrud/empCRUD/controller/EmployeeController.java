package edu.employeCrud.empCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/employees")
	List<Employee> getEMpList() {
		return empService.findAll();
	}


	@GetMapping("/employees/{employeeId}")
	Employee getEmployee(@PathVariable int employeeId) {
		Employee employee = empService.findById(employeeId);
		if (employee == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + employeeId);
		}
		return employee;
	}
	@PostMapping("/employees")
	Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(null);
		return empService.save(employee);
	}

	@PutMapping("/employees")
	Employee updateEmployee(@RequestBody Employee employee) {
		return empService.save(employee);
	}


	@DeleteMapping("/employees/{employeeId}")
	String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = empService.findById(employeeId);
		if (employee == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee id not found - " + employeeId);
		}
		empService.deleteById(employeeId);
		return "Deleted employee id - " + employeeId;
	}

}
