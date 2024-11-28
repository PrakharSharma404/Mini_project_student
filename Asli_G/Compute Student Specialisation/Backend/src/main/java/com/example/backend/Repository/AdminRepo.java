package com.example.backend.Repository;

import com.example.backend.Entity.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdminRepo extends JpaRepository<Employees, Long> {

    //@Query("SELECT e FROM Employees e WHERE e.email = :email and e.department.department_name ='admin'")
    Employees findByEmail(String email);
}
