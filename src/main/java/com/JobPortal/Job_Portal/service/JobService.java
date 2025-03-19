package com.JobPortal.Job_Portal.service;

import com.JobPortal.Job_Portal.model.Job;
import com.JobPortal.Job_Portal.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public List<Job> getAllJobs() {
        return jobRepository.findAll();
    }


    public Job getJobById(Long id) {
        return jobRepository.findById(id).orElse(null);
    }

    public void deleteJobById(Long id) {
         jobRepository.deleteById(id);
    }


    public Job updateJob(Job jobupdate, Long id) {
        Job job = getJobById(id);
        job.setTitle(jobupdate.getTitle());
        job.setDescription(jobupdate.getDescription());
        job.setLocation(jobupdate.getLocation());
        return jobRepository.save(job);
    }
}
