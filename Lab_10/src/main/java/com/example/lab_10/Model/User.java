package com.example.lab_10.Model;

import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(25) not null ")
    @Pattern(regexp = "^[a-zA-Z]+$")
    private String name;
    @NotEmpty
    @Email
    @Column(columnDefinition = "varchar(40) not null unique")
    private String email;
    @NotEmpty
    @Column(columnDefinition = "varchar(15) not null")
    private String password;
    @NotNull
    @Min(21)
    @Column(columnDefinition = "int not null") //check (age > 21)
    private int age;
    @NotEmpty
    @Pattern(regexp = "^(JOB_SEEKER|EMPLOYER)$")
    @Column(columnDefinition = "varchar(11) not null") //check (role = 'JOB_SEEKER' or role = 'EMPLOYER')
    private String role;





















}
