package edu.employeCrud.empCRUD.DAO;

import java.util.List;

import edu.employeCrud.empCRUD.entity.Employee;

public interface EmployeeDAO {
	List<Employee> findAll();
}
