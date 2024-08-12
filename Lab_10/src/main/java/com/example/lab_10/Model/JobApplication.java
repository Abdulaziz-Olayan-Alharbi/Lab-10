package com.example.lab_10.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Data
@RequiredArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "apply")
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;
    @NotNull
    @Column(columnDefinition = "int not null")
    private Integer userId;























}
