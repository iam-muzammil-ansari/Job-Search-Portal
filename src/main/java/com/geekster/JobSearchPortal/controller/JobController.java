package com.geekster.JobSearchPortal.controller;

import com.geekster.JobSearchPortal.model.Job;
import com.geekster.JobSearchPortal.services.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    JobService jobService;

    @GetMapping
    public List<Job> getAllJobs() {
        return jobService.getAllJobs();
    }

    @GetMapping("/JobId/{id}")
    public Optional<Job> getJobById(@PathVariable Long id) {
        return jobService.getJobById(id);
    }

    @PostMapping("/createJob")
    public Job createJob(@Validated @RequestBody Job job) {
        return jobService.saveJob(job);
    }

    @PutMapping("/updateJob/{id}")
    public Job updateJob(@PathVariable Long id, @Validated @RequestBody Job job) {
        Optional<Job> existingJob = jobService.getJobById(id);
        if (existingJob.isPresent()) {
            job.setId(id);
            return jobService.saveJob(job);
        } else {
            throw new RuntimeException("Job not found with ID: " + id);
        }
    }

    @DeleteMapping("/deleteJob/{id}")
    public String deleteJob(@PathVariable Long id) {
        return jobService.deleteJob(id);
    }

    @GetMapping("/search/title")
    public List<Job> searchByTitle(@RequestParam String title) {
        return jobService.findJobsByTitleContaining(title);
    }

    @GetMapping("/search/description")
    public List<Job> searchByDescription(@RequestParam String description) {
        return jobService.findJobsByDescriptionContaining(description);
    }

    @GetMapping("/search/location-salary")
    public List<Job> searchByLocationAndSalary(@RequestParam String location, @RequestParam Double minSalary) {
        return jobService.findJobsByLocationAndSalary(location, minSalary);
    }
}
