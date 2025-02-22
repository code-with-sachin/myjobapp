package com.sachinsk.myjobapp.job;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class JobController {

    //No need to initialize this, as we have annotated the JobServiceImpl with @Service.
    // So spring boot will manage the object creation & inject it at run time -> For this just define a constructor (refer below jobService)
    private JobService jobService;

    //Now spring boot will take care of object creation at runtime for this controller & will initialize it
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/jobs")
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping("/jobs")
    public String createjob(@RequestBody Job job) {
        jobService.createJob(job);
        return "Job created successfully!";
    }

    //Note the {id} is the Query parameters
    @GetMapping("/jobs/{id}")
    public Job findJobById(@PathVariable(value = "id") Long id) {
        Job job = jobService.getJobById(id);
        return job;
    }

}
