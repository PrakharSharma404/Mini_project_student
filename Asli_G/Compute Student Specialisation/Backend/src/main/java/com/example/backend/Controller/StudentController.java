package com.example.backend.Controller;

import com.example.backend.DTO.dataToSend;
import com.example.backend.Entity.Students;
import com.example.backend.Repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentRepo studentRepo;

    // Endpoint for fetching students with their specialization details
    @CrossOrigin
    @GetMapping("/Specialization")
    public List<dataToSend> findAllStudents() {
        // Fetching custom data from the repository
        List<Object[]> resultList = studentRepo.target();

        // Converting raw results into dataToSend DTOs
        List<dataToSend> customResults = new ArrayList<>();
        for (Object[] result : resultList) {
            dataToSend customResult = new dataToSend();
            customResult.setRoll_number((String) result[0]);
            customResult.setFirst_name((String) result[1]);
            customResult.setLast_name((String) result[2]);
            customResult.setDept((String) result[3]);
            customResult.setSpecialisation((String) result[4]);
            customResult.setCredit((int) result[5]);
            customResults.add(customResult);
        }

        return customResults;
    }

    // Endpoint to fetch all students (raw data)
    @GetMapping("/r")
    public List<Students> tmp() {
        return studentRepo.findAll();
    }
}


//@RestController
//@RequestMapping("/student")
//public class StudentController {
//    @Autowired
//    private StudentRepo studentRepo;
//
//    @CrossOrigin()
//    @GetMapping("/Specialization")
//    public List<dataToSend> findALlStudents(){
//
//        List<Object[]> resultList = studentRepo.target();
//        System.out.println("Printing the result list from the student controller"+resultList);
//
//        List<dataToSend> customResults = new ArrayList<>();
//        for (Object[] result : resultList) {
//            dataToSend customResult = new dataToSend();
//            customResult.setRoll_number((String) result[0]);
//            customResult.setFirst_name((String) result[1]);
//            customResult.setLast_name((String) result[2]);
//            customResult.setDept((String) result[3]);
//            customResult.setSpecialisation((String) result[4]);
//            customResult.setCredit((Long) result[5]);
//            customResults.add(customResult);
//
//
//        }
//
//        return customResults;
//    }
//
//    @CrossOrigin()
//    @GetMapping("/r")
//    public List<Students> tmp()
//    {
//        return studentRepo.findAll();
//    }
//}
