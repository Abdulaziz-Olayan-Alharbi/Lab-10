package com.example.lab_10.Service;


import com.example.lab_10.Model.JobApplication;
import com.example.lab_10.Repository.JobApplicationRepository;
import com.example.lab_10.Repository.JobPostRepository;
import com.example.lab_10.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepository jobApplicationRepository;
    private final UserRepository userRepository;
    private final JobPostRepository jobpostRepository;

    public ArrayList<JobApplication> getJobApplications() {
        return new ArrayList<JobApplication>(jobApplicationRepository.findAll());
    }

    public String apply(JobApplication jobApplication) {
        if (userRepository.existsById(jobApplication.getUserId()) && userRepository.getById(jobApplication.getUserId()).getRole().equals("JOB_SEEKER")) {
            if (jobpostRepository.existsById(jobApplication.getJobPostId())) {
                jobApplicationRepository.save(jobApplication);
                return "true";
            }
            return "Job Post Not Found";
        }
        return "Job Seeker Not Found";
    }


    public String updateJobApplication(Integer id,JobApplication jobApplication) {
        JobApplication j = jobApplicationRepository.getById(id);
        if (j != null) {
            if (userRepository.existsById(jobApplication.getUserId()) && userRepository.getById(jobApplication.getUserId()).getRole().equals("JOB_SEEKER")) {
                if (jobpostRepository.existsById(jobApplication.getJobPostId())) {
                    j.setJobPostId(jobApplication.getJobPostId());
                    j.setUserId(jobApplication.getUserId());
                    jobApplicationRepository.save(j);
                    return "true";
                }
                return "Job Post Not Found";
            }
            return "Job Seeker Not Found";
        }
        return "Job Application Not Found";
    }

    public boolean withdraw(Integer id) {
        if (jobApplicationRepository.existsById(id)) {
            jobApplicationRepository.deleteById(id);
            return true;
        }
        return false;
    }




















}
