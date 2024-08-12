package com.example.lab_10.Service;


import com.example.lab_10.Model.JobPost;
import com.example.lab_10.Repository.JobPostRepository;
import jakarta.persistence.Table;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
@RequiredArgsConstructor

public class JobPostService {
    private final JobPostRepository jobPostRepository;

    public ArrayList<JobPost> getJobPosts() {
        return new ArrayList<JobPost>(jobPostRepository.findAll());
    }

    public void addJobPost(JobPost jobPost) {
        jobPostRepository.save(jobPost);
    }

    public boolean updateJobPost(Integer id,JobPost jobPost) {
        JobPost j = jobPostRepository.getById(id);
        if(j != null) {
            j.setTitle(jobPost.getTitle());
            j.setDescription(jobPost.getDescription());
            j.setLocation(jobPost.getLocation());
            j.setSalary(jobPost.getSalary());
            j.setPostingDate(j.getPostingDate());
            jobPostRepository.save(j);
            return true;
        }
        return false;
    }

    public boolean deleteJobPost(Integer id) {
        if (jobPostRepository.existsById(id)) {
            jobPostRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
