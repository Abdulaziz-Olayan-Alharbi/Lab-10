package com.example.lab_10.Controller;


import com.example.lab_10.Api.ApiResponse;
import com.example.lab_10.Model.JobApplication;
import com.example.lab_10.Service.JobApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/job")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

    @GetMapping("/get")
    public ResponseEntity getJobApplications() {
        return ResponseEntity.status(200).body(jobApplicationService.getJobApplications());
    }

    @PostMapping("/add")
    public ResponseEntity apply(@Valid @RequestBody JobApplication jobApplication , Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (jobApplicationService.apply(jobApplication).equals("true")){
            return ResponseEntity.status(200).body(new ApiResponse("Job applied Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse(jobApplicationService.apply(jobApplication)));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@Valid @RequestBody JobApplication jobApplication, Errors errors) {
        if (errors.hasErrors()) {
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        if (jobApplicationService.updateJobApplication(id, jobApplication).equals("true")){
            return ResponseEntity.status(200).body(new ApiResponse("Job updated Successfully"));
        }
        return ResponseEntity.status(400).body(jobApplicationService.updateJobApplication(id, jobApplication));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity withdraw(@PathVariable Integer id) {
        if (jobApplicationService.withdraw(id)){
            return ResponseEntity.status(200).body(new ApiResponse("Job Application withdrawn Successfully"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("Job Application not found"));
    }




















}
