package com.example.lab_10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty
    @Size(min = 4)
    @Column(columnDefinition = "varchar(30) not null")
    private String title;
    @NotEmpty
    @Column(columnDefinition = "varchar(300) not null")
    private String description;
    @NotEmpty
    @Column(columnDefinition = "varchar(30) not null")
    private String location;
    @NotNull
    @PositiveOrZero
    @Column(columnDefinition = "int not null") //check (salary >= 0 )
    private int salary;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "date")
    private LocalDate postingDate = LocalDate.now();



















}
