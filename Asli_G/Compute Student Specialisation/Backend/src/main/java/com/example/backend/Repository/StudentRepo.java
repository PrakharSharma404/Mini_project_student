package com.example.backend.Repository;
import com.example.backend.Entity.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Students, Long> {

//    @Query("SELECT  s.roll_number,s.first_name,s.last_name, s.domain.program, sp.specialisation_name, SUM(c.credits)  " +
//            "FROM Students s " +
//            "JOIN s.student_course c " +
//            "JOIN c.specialisation_Course sp " +
//            "GROUP BY s.student_id, sp.specialisation_id " +
//            "HAVING SUM(c.credits) > 20 ORDER BY s.roll_number")
//    List<Object[]> target();

    @Query("SELECT s.roll_number, s.first_name, s.last_name, s.domain.program, s.specialisation.specialisation_name, s.total_credit " +
            "FROM Students s " +
            "JOIN s.domain d " +
            "JOIN s.specialisation sp " +
            "WHERE s.total_credit > 20")

//    @Query("SELECT s.roll_number, s.first_name, s.last_name, s.domain.program, s.specialisation.specialisation_name, SUM(c.credits) " +
//            "FROM Students s " +
//            "JOIN s.domain d " +
//            "JOIN s.specialisation sp " +
//            "JOIN StudentCourse sc ON sc.student = s " +
//            "JOIN sc.course c " +
//            "JOIN SpecialisationCourse spc ON spc.course = c " +
//            "WHERE spc.specialisation = sp " +
//            "GROUP BY s.roll_number, s.first_name, s.last_name, s.domain.program, s.specialisation.specialisation_name " +
//            "HAVING SUM(c.credits) > 20")

    List<Object[]> target();

}



