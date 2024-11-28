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
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long department_id;
    @Column(nullable = false)
    private String department_name;

    @Column(nullable = false)
    private long capacity;



    @OneToMany(mappedBy="department")
    private Set<Employees> employees;
}
