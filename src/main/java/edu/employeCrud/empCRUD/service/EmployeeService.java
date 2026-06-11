package edu.employeCrud.empCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.employeCrud.empCRUD.DAO.EmployeeDAO;
import edu.employeCrud.empCRUD.entity.Employee;

@Service
public class EmployeeService {
	EmployeeDAO empDao;

	@Autowired
	public EmployeeService(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	public List<Employee> getEmps() {
		return empDao.findAll();

	}

}
