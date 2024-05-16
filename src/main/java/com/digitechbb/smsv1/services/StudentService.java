package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.entities.Student;

import java.util.List;
import java.util.Optional;

public interface StudentService {
     Student saveStudent(Student student);
     List<Student> getAll();
     Student updateStudent(Student student);
     void delete(Long id);
     Optional<Student> getById(Long id);

}
