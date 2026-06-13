package edu.employeCrud.empCRUD.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.employeCrud.empCRUD.DAO.JobDAO;
import edu.employeCrud.empCRUD.entity.Job;

@Service
public class JobServiceImpl implements JobService {

    private JobDAO jobDao;

    @Autowired
    public JobServiceImpl(JobDAO jobDao) {
        this.jobDao = jobDao;
    }

    @Override
    public List<Job> findAll() {
        return jobDao.findAll();
    }

    @Override
    public Job findById(int id) {
        return jobDao.findById(id);
    }

    @Override
    @Transactional
    public Job save(Job job) {
        return jobDao.save(job);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        jobDao.deleteById(id);
    }
}
