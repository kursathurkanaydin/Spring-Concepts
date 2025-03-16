package com.kha.studentdemo.controller;

import com.kha.studentdemo.dto.request.CreateStudentRequest;
import com.kha.studentdemo.dto.response.ShowStudentResponse;
import com.kha.studentdemo.entity.Student;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@RestController
public interface IStudentController {
    List<ShowStudentResponse> getAllStudents();
    ShowStudentResponse getStudentById(int id);
    ShowStudentResponse createStudent(CreateStudentRequest createStudentRequest);
    boolean deleteStudentById(int id);

}
