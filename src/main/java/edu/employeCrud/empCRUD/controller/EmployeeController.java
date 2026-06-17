package edu.employeCrud.empCRUD.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.employeCrud.empCRUD.dto.EmployeeDTO;
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
	List<EmployeeDTO> getEMpList() {
		List<EmployeeDTO> result = new ArrayList<>();
		for (Employee emp : empService.findAll()) {
			result.add(new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail()));
		}
		return result;
	}

	// http://localhost:8080/api/employees/{employeeId}
	@GetMapping("/employees/{employeeId}")
	EmployeeDTO getEmployee(@PathVariable int employeeId) {
		Employee employee = empService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		return new EmployeeDTO(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getEmail());
	}

	// http://localhost:8080/api/employees
	@PostMapping("/employees")
	Employee addEmployee(@RequestBody Employee employee) {
		employee.setId(null);
		return empService.save(employee);
	}

	// http://localhost:8080/api/employees
	@PutMapping("/employees")
	Employee updateEmployee(@RequestBody Employee employee) {
		return empService.save(employee);
	}

	// http://localhost:8080/api/employees/{employeeId}
	@DeleteMapping("/employees/{employeeId}")
	String deleteEmployee(@PathVariable int employeeId) {
		Employee employee = empService.findById(employeeId);
		if (employee == null) {
			throw new RuntimeException("Employee id not found - " + employeeId);
		}
		empService.deleteById(employeeId);
		return "Deleted employee id - " + employeeId;
	}

}
