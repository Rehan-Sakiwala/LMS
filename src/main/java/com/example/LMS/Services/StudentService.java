package com.example.LMS.Services;

import com.example.LMS.DTOs.StudentUpdateMobileRequestDto;
import com.example.LMS.Enums.CardStatus;
import com.example.LMS.Models.Card;
import com.example.LMS.Models.Student;
import com.example.LMS.Repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public String createStudent(Student student){
        Card card=new Card();
        card.setCardStatus(CardStatus.ACTIVATED);
        card.setStudentVar(student);

        student.setCard(card);

        studentRepository.save(student);

        return "Student and card added ;-)";
    }

    public String getStudentByEmail(String email){
        Student student=studentRepository.findByEmail(email);
        return student.getName();
    }

    public String updateMobile(StudentUpdateMobileRequestDto studentUpdateMobileRequestDto){
        Student originalStudent=studentRepository.findById(studentUpdateMobileRequestDto.getId()).get();
        originalStudent.setMobNo(studentUpdateMobileRequestDto.getMobileNo());
        studentRepository.save(originalStudent);
        return "Mobile number updated successfully";
    }
}
