package com.JobPortal.Job_Portal.controller;

import com.JobPortal.Job_Portal.model.Job;
import com.JobPortal.Job_Portal.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jobs")
public class JobController {

    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping
    public Job createJob(@RequestBody Job job){
        return jobService.createJob(job);
    }

    @GetMapping
    public List<Job> getAllJobs(){
        return jobService.getAllJobs();
    }

    @GetMapping("/{id}")
    public Job getJobById(@PathVariable Long id){
        return jobService.getJobById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteJobById(@PathVariable Long id){
         jobService.deleteJobById(id);
    }

    @PutMapping("/{id}")
    public Job updateJob(@RequestBody Job jobupdate,@PathVariable Long id){
        return jobService.updateJob(jobupdate,id);
    }
}
