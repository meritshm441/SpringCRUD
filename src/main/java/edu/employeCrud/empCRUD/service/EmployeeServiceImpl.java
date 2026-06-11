package edu.employeCrud.empCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.employeCrud.empCRUD.DAO.EmployeeDAO;
import edu.employeCrud.empCRUD.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDAO empDao;

	@Autowired
	public EmployeeServiceImpl(EmployeeDAO empDao) {
		this.empDao = empDao;
	}

	@Override
	public List<Employee> findAll() {
		return empDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		return empDao.findById(id);
	}

	@Override
	@Transactional
	public Employee save(Employee employee) {
		return empDao.save(employee);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		empDao.deleteById(id);
	}

}
