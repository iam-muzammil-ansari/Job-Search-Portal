package com.geekster.JobSearchPortal.services;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.repository.JobRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobService {

    @Autowired
    JobRepo jobRepository;


    public JobService(JobRepo jobRepository) {
        this.jobRepository = jobRepository;
    }

    public List<Job> getAllJobs() {
        return (List<Job>) jobRepository.findAll();
    }

    public Optional<Job> getJobById(Long id) {
        return jobRepository.findById(id);
    }

    public Job saveJob(Job job) {
        return jobRepository.save(job);
    }

    public String deleteJob(Long id) {
        if (jobRepository.existsById(id)) {
            jobRepository.deleteById(id);
            return "Job with Id: "+id+" is Deleted";
        }
        return "Job with Id: "+id+" is not Exist";
    }

    public List<Job> findJobsByTitleContaining(String title) {
        return jobRepository.findByTitleContaining(title);
    }
    public List<Job> findJobsByDescriptionContaining(String description) {
        return jobRepository.findByDescriptionContaining(description);
    }
    public List<Job> findJobsByLocationAndSalary(String location, Double minSalary) {
        return jobRepository.findJobsByLocationAndSalary(location, minSalary);
    }
}
