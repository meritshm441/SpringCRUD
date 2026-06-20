package edu.employeCrud.empCRUD.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.employeCrud.empCRUD.entity.Job;
import edu.employeCrud.empCRUD.exception.ResourceNotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

@Repository
public class JobDAOImpl implements JobDAO {

    private EntityManager entityManager;

    @Autowired
    public JobDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Job> findAll() {
        TypedQuery<Job> query = entityManager.createQuery("from Job", Job.class);
        return query.getResultList();
    }

    @Override
    public Job findById(int id) {
        return entityManager.find(Job.class, id);
    }

    @Override
    public Job save(Job job) {
        if (job.getId() == null || job.getId() == 0) {
            entityManager.persist(job);
            return job;
        } else {
            return entityManager.merge(job);
        }
    }

    @Override
    public void deleteById(int id) {
        Job job = entityManager.find(Job.class, id);
        if (job == null) {
            throw new ResourceNotFoundException("Job id not found - " + id);
        }
        entityManager.remove(job);
    }
}
