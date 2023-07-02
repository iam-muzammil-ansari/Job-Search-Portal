package com.geekster.JobSearchPortal.repository;

import com.geekster.JobSearchPortal.model.Job;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface JobRepo extends CrudRepository<Job,Long> {
    List<Job> findByTitleContaining(String title);

    List<Job> findByDescriptionContaining(String description);

    @Query("SELECT j FROM Job j WHERE j.location = :location AND j.salary >= :minSalary")
    List<Job> findJobsByLocationAndSalary(String location, Double minSalary);
}
