package com.JobPortal.Job_Portal.repository;

import com.JobPortal.Job_Portal.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {
}
