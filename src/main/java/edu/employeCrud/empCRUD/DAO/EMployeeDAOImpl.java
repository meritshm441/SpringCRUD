package edu.employeCrud.empCRUD.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.employeCrud.empCRUD.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class EMployeeDAOImpl implements EmployeeDAO {
	private EntityManager entityManager;

	@Autowired
	public EMployeeDAOImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Employee> findAll() {
		// creating custom query
		TypedQuery<Employee> myQuery = entityManager.createQuery("from Employee", Employee.class);
		// execute the query
		List<Employee> result = myQuery.getResultList();
		return result;
	}

	@Override
	public Employee findById(int id) {
		return entityManager.find(Employee.class, id);
	}

	@Override
	public Employee save(Employee employee) {
		return entityManager.merge(employee);
	}

	@Override
	public void deleteById(int id) {
		Employee employee = entityManager.find(Employee.class, id);
		entityManager.remove(employee);
	}

}
