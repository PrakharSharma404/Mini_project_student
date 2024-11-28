package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SpecialisationCourse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_course_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "specialisation_id", nullable = false)
    private Specialisation specialisation;

    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}