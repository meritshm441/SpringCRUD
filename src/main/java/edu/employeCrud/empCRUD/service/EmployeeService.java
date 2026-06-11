package edu.employeCrud.empCRUD.service;

import java.util.List;

import edu.employeCrud.empCRUD.entity.Employee;

public interface EmployeeService {
	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee employee);
	void deleteById(int id);
}
