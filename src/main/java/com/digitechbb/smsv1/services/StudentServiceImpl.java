package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.StudentMapper;
import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.repositories.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        Student student=studentMapper.ToStudent(studentDto);
        Student  savedStudent = studentRepository.save(student);
        return studentMapper.studentToDto(savedStudent);
    }


    @Override
    public List<StudentDto> getAll() {

        List<Student> students=studentRepository.findAll();

        if (students==null)
            return null;
        List<StudentDto> studentsDtos = new ArrayList<>();
        for(Student s : students){
            studentsDtos.add(studentMapper.studentToDto(s))    ;
        }
        return studentsDtos;
//        return students.stream()
//                .map(studentMapper::studentToDto)
//                .collect(Collectors.toList());
    }
    @Override
    public StudentDto updateStudent(StudentDto studentDto) {

        Student existingStudent = studentRepository.findByStudentNumber(studentDto.studentNumber());
        if (existingStudent==null) {
            return null;
        }

        existingStudent.setStudentNumber(studentDto.studentNumber());
        existingStudent.setFirstName(studentDto.firstName());
        existingStudent.setLastName(studentDto.lastName());
        existingStudent.setAddress(studentDto.address());
        existingStudent.setGender(studentDto.gender());
        existingStudent.setDateOfBirth(studentDto.dateOfBirth());
        existingStudent.setEmail(studentDto.email());
        existingStudent.setPhone(studentDto.phone());
        existingStudent.setStatut(studentDto.statut());
        existingStudent.setSchoolLevel(studentDto.schoolLevel());
        existingStudent.setModeOfPayment(studentDto.modeOfPayment());
        existingStudent.setStartDate(studentDto.startDate());
        existingStudent.setParentContact(studentDto.parentContact());

        Student updatedStudent = studentRepository.save(existingStudent);


        return studentMapper.studentToDto(updatedStudent);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto getById(Long id) {
        return studentMapper.studentToDto(studentRepository.findById(id).orElse(null));
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

}
