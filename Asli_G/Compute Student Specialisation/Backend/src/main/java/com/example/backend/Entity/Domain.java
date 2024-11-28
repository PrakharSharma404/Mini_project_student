package com.example.backend.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long domain_id;
    @Column(nullable = false)
    private String program;
    @Column(nullable = false)
    private String batch;

    @Column(nullable = false)
    private long capacity;

    private String qualification;

    @OneToMany(mappedBy="domain")
    private Set<Students> students;

}
