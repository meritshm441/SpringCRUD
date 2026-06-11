package edu.employeCrud.empCRUD.DAO;

import java.util.List;

import edu.employeCrud.empCRUD.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
	Employee findById(int id);
	Employee save(Employee employee);
	void deleteById(int id);
}
