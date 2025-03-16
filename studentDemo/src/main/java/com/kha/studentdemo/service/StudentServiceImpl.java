package com.kha.studentdemo.service;

import com.kha.studentdemo.dto.request.CreateStudentRequest;
import com.kha.studentdemo.dto.response.ShowStudentResponse;
import com.kha.studentdemo.entity.Student;
import com.kha.studentdemo.repository.StudentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements IStudentService{
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Student> findStudentById(int id) {
        return studentRepository.findById(id);
    }

    @Override
    public ShowStudentResponse createStudent(CreateStudentRequest createStudentRequest) {
        return fromStudentToShow(studentRepository.save(fromCreateToStudent(createStudentRequest)));
    }

    @Override
    public boolean deleteStudentById(int id) {
        Optional<Student> student = findStudentById(id);
        if (student.isPresent()){
            studentRepository.delete(student.get());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public ShowStudentResponse updateStudent(CreateStudentRequest createStudentRequest) {
        return null;
    }

    @Override
    public List<ShowStudentResponse> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> {
            ShowStudentResponse response = new ShowStudentResponse();
            BeanUtils.copyProperties(student, response);
            return response;
        }).collect(Collectors.toList());
    }

    public Student fromCreateToStudent(CreateStudentRequest createStudentRequest){
        Student student = new Student();
        BeanUtils.copyProperties(createStudentRequest, student);
        return student;
    }

    public ShowStudentResponse fromStudentToShow(Student student){
        ShowStudentResponse showStudentResponse = new ShowStudentResponse();
        BeanUtils.copyProperties(student, showStudentResponse);
        return showStudentResponse;
    }
}
