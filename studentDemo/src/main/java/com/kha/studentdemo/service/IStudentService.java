package com.kha.studentdemo.service;

import com.kha.studentdemo.dto.request.CreateStudentRequest;
import com.kha.studentdemo.dto.response.ShowStudentResponse;
import com.kha.studentdemo.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IStudentService {
    Optional<Student> findStudentById(int id);
    ShowStudentResponse createStudent(CreateStudentRequest createStudentRequest);
    boolean deleteStudentById(int id);
    ShowStudentResponse updateStudent(CreateStudentRequest createStudentRequest);
    List<ShowStudentResponse> getAllStudents();
}
