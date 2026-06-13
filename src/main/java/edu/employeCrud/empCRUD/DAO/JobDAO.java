package edu.employeCrud.empCRUD.DAO;

import java.util.List;

import edu.employeCrud.empCRUD.entity.Job;

public interface JobDAO {
    List<Job> findAll();
    Job findById(int id);
    Job save(Job job);
    void deleteById(int id);
}
