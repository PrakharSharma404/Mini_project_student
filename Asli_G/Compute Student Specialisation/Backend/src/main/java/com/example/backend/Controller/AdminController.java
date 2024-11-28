package com.example.backend.Controller;


import com.example.backend.DTO.AuthResponse;
import com.example.backend.DTO.dataForLogin;
import com.example.backend.Entity.Employees;
import com.example.backend.Repository.AdminRepo;
import com.example.backend.helper.JWTHelper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminRepo adminRepo;

    private final JWTHelper JWTHelper;

    @PostMapping("/login")
    private ResponseEntity<AuthResponse> loginAdmin(@RequestBody dataForLogin dataforlogin)
    {
        Employees employees = adminRepo.findByEmail(dataforlogin.email);
        String token = JWTHelper.generateToken(dataforlogin.email);
        if(employees == null || !employees.getDepartment().getDepartment_name().equals("ADMIN"))
        {
            return ResponseEntity.ok(new AuthResponse("Unauthorized", null));
        }
        else {
            if(employees.getPassword().equals(dataforlogin.password) )
            {
                return ResponseEntity.ok(new AuthResponse("Success", token));
            }
            else {
                return ResponseEntity.ok(new AuthResponse("Incorrect Password", null));
            }
        }


    }

}
