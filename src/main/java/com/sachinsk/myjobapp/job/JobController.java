package com.sachinsk.myjobapp.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    //@GetMapping("/jobs")
    @RequestMapping(value = "/jobs", method = RequestMethod.GET)
    public ResponseEntity<List<Job>> findAll() {
        return ResponseEntity.ok(jobService.findAll());
        // return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    //@PostMapping("/jobs")
    @RequestMapping(value = "/jobs", method = RequestMethod.POST)
    public ResponseEntity<String> createjob(@RequestBody Job job) {
        jobService.createJob(job);
        return new ResponseEntity<>("Job created successfully!", HttpStatus.CREATED);
    }

    //Note the {id} is the Query parameters
    //@GetMapping("/jobs/{id}")
    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.GET)
    public ResponseEntity<Job> findJobById(@PathVariable(value = "id") Long id) {
        Job job = jobService.getJobById(id);
        if (job != null) {
            return new ResponseEntity<>(job, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@DeleteMapping("/jobs/{id}")
    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteJob(@PathVariable(value = "id") Long id) {
        boolean deleted = jobService.deleteJobById(id);
        if (deleted) {
            return new ResponseEntity<>("Job Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //@PutMapping("/jobs/{id}")
    @RequestMapping(value = "/jobs/{id}", method = RequestMethod.PUT)
    public ResponseEntity<String> updatejob(@PathVariable Long id, @RequestBody Job updatedJob) {
        boolean updated = jobService.updateJobById(id, updatedJob);
        if (updated) {
            return new ResponseEntity<>("Job updated successfully!", HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
