package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.StudentMapper;
import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public StudentDto saveStudentDto(StudentDto studentDto) {
        Student student = studentMapper.ToStudent(studentDto);
        Student savedStudent = studentRepository.save(student);
        return studentMapper.toDto(savedStudent);
    }


    @Override
    public List<StudentDto> getAll() {

        return studentRepository.findAll().stream().map(studentMapper::toDto).collect(Collectors.toList());

    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {

        Student existingStudent = studentRepository.findByStudentNumber(studentDto.studentNumber());
        if (existingStudent == null) {
            return null;
        }

        Student updatedStudent = studentMapper.ToStudent(studentDto);

        updatedStudent.setId(existingStudent.getId());

        return studentMapper.toDto(studentRepository.save(updatedStudent));
    }

    @Override
    public boolean delete(Long id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            studentRepository.deleteById(id);
            return true;

        } else {
            return false;
        }

    }

    @Override
    public StudentDto getById(Long id) {
        return studentMapper.toDto(studentRepository.findById(id).orElse(null));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

}
