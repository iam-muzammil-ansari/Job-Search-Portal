package com.geekster.JobSearchPortal.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Jobs")
public class Job {

    @Id
    private Long id;

    @NotEmpty
    private String title;

    private String description;

    private String location;

    @Min(value = 20000, message = "Salary should be above 20,000")
    private Double salary;

    @NotEmpty
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]+$", message = "Please Enter Valid Email Address")
    private String companyEmail;

    private String companyName;

    private String employerName;

    @Enumerated(EnumType.STRING)
    private JobType jobType;

    private LocalDate appliedDate;
}
