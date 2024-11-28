package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.Year;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;
    @Column(unique = true, nullable = false)
    private String roll_number;

    @Column( nullable = false)
    private String first_name;

    private String last_name;
    @Column(unique = true, nullable = false)
    private String email;
    private String photograph_path;
    @Column( nullable = false)
    private String cgpa;
    @Column(nullable = false)
    private int total_credit;
    private LocalDate graduation_year;


    @ManyToOne
    @JoinColumn(name = "domain_id" )
    private Domain domain;



    @ManyToOne
    @JoinColumn(name="specialisation_id", nullable=false)
    private Specialisation specialisation;



}
