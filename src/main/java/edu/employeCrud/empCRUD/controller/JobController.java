package edu.employeCrud.empCRUD.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.employeCrud.empCRUD.entity.Job;
import edu.employeCrud.empCRUD.service.JobService;

@RestController
@RequestMapping("/api")
public class JobController {

    private JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobService.findAll();
    }

    @GetMapping("/jobs/{jobId}")
    public Job getJob(@PathVariable int jobId) {
        Job job = jobService.findById(jobId);
        if (job == null) {
            throw new RuntimeException("Job id not found - " + jobId);
        }
        return job;
    }

    @PostMapping("/jobs")
    public Job addJob(@RequestBody Job job) {
        job.setId(null);
        return jobService.save(job);
    }

    @PutMapping("/jobs")
    public Job updateJob(@RequestBody Job job) {
        return jobService.save(job);
    }

    @DeleteMapping("/jobs/{jobId}")
    public String deleteJob(@PathVariable int jobId) {
        Job job = jobService.findById(jobId);
        if (job == null) {
            throw new RuntimeException("Job id not found - " + jobId);
        }
        jobService.deleteById(jobId);
        return "Deleted job id - " + jobId;
    }
}
