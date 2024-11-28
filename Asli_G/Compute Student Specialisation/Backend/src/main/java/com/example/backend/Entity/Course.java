package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.Set;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;

    @Column(unique = true, nullable = false)
    private String course_code;

    @Column(nullable = false)
    private String course_name;

    private String description;
    @Column(nullable = false)
    private LocalDate year;
    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private long credits;

    @Column(nullable = false)
    private long capacity;


}
