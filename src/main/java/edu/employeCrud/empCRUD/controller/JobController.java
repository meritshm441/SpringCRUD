package edu.employeCrud.empCRUD.controller;

import java.util.ArrayList;
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

import edu.employeCrud.empCRUD.dto.EmployeeDTO;
import edu.employeCrud.empCRUD.dto.JobDTO;
import edu.employeCrud.empCRUD.entity.Employee;
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

    private JobDTO convertToDTO(Job job) {
        List<EmployeeDTO> empDTOs = new ArrayList<>();
        if (job.getEmployees() != null) {
            for (Employee emp : job.getEmployees()) {
                empDTOs.add(new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail()));
            }
        }
        return new JobDTO(job.getId(), job.getTitle(), job.getMode(), empDTOs);
    }

    @GetMapping("/jobs")
    public List<JobDTO> getAllJobs() {
        List<JobDTO> result = new ArrayList<>();
        for (Job job : jobService.findAll()) {
            result.add(convertToDTO(job));
        }
        return result;
    }

    @GetMapping("/jobs/{jobId}")
    public JobDTO getJob(@PathVariable int jobId) {
        Job job = jobService.findById(jobId);
        if (job == null) {
            throw new RuntimeException("Job id not found - " + jobId);
        }
        return convertToDTO(job);
    }

    @GetMapping("/jobs/{jobId}/employees")
    public List<EmployeeDTO> getEmployeesByJob(@PathVariable int jobId) {
        Job job = jobService.findById(jobId);
        if (job == null) {
            throw new RuntimeException("Job id not found - " + jobId);
        }
        List<EmployeeDTO> empDTOs = new ArrayList<>();
        if (job.getEmployees() != null) {
            for (Employee emp : job.getEmployees()) {
                empDTOs.add(new EmployeeDTO(emp.getId(), emp.getFirstName(), emp.getLastName(), emp.getEmail()));
            }
        }
        return empDTOs;
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
