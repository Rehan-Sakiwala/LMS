package com.example.LMS.Controllers;

import com.example.LMS.DTOs.StudentUpdateMobileRequestDto;
import com.example.LMS.Models.Student;
import com.example.LMS.Services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class StudentController {
    @Autowired
    StudentService studentService;

    @PostMapping("/add-student")
    public String createStudent(@RequestBody Student student){
        return studentService.createStudent(student);
    }

    @GetMapping("/get_user")
    public String getUserByEmail(@RequestParam("email")String email){
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/update_mobile")
    public String updateMobile(@RequestBody StudentUpdateMobileRequestDto studentUpdateMobileRequestDto){
        return studentService.updateMobile(studentUpdateMobileRequestDto);
    }
}
