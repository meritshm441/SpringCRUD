package edu.employeCrud.empCRUD.service;

import java.util.List;

import edu.employeCrud.empCRUD.entity.Job;

public interface JobService {
    List<Job> findAll();
    Job findById(int id);
    Job save(Job job);
    void deleteById(int id);
}
