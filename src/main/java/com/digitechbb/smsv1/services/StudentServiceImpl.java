package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;



    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);//modifier add bzaf mazal ...
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> getById(Long id) {
        return studentRepository.findById(id);
    }
}
