package com.kha.studentdemo.controller;

import com.kha.studentdemo.dto.request.CreateStudentRequest;
import com.kha.studentdemo.dto.response.ShowStudentResponse;
import com.kha.studentdemo.entity.Student;
import com.kha.studentdemo.service.StudentServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
public class StudentControllerImpl implements IStudentController{
    private final StudentServiceImpl studentService;

    public StudentControllerImpl(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @Override
    @GetMapping("/list")
    public List<ShowStudentResponse> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    @GetMapping("/list/{id}")
    public ShowStudentResponse getStudentById(@PathVariable int id) {
        Optional<Student> student = studentService.findStudentById(id);
        return student.map(studentService::fromStudentToShow).orElse(null);
    }

    @Override
    @PostMapping("/create")
    public ShowStudentResponse createStudent(@RequestBody CreateStudentRequest createStudentRequest) {
        return studentService.createStudent(createStudentRequest);
    }

    @Override
    @DeleteMapping("/delete/{id}")
    public boolean deleteStudentById(@PathVariable int id) {
        return studentService.deleteStudentById(id);
    }
}
