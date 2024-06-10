package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;

import java.util.List;

public interface StudentService {
    Student saveStudent(Student student);

    StudentDto saveStudentDto(StudentDto studentDto);

    List<StudentDto> getAll();

    StudentDto updateStudent(StudentDto studentDto);

    boolean delete(Long id);

    StudentDto getById(Long id);

    Student getStudentById(Long id);

}
