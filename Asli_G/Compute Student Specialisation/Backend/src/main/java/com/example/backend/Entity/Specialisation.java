package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Specialisation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long specialisation_id;

     @Column(unique = true, nullable = false)
    private  String code;

     @Column(nullable = false)
    private String specialisation_name;

     private String description;

     private LocalDate year;

     private long required_credit;

}
