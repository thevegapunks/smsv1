package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class StudentController {

    private StudentService studentService;

    @PostMapping("/saveStudent")
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        Student student1 = studentService.saveStudent(student);
        return ResponseEntity.ok(student1);
    }

    @PostMapping("saveStudentDto")
    public ResponseEntity<StudentDto> saveStudentDto(@RequestBody StudentDto studentDto) {
        StudentDto studentDto1 = studentService.saveStudentDto(studentDto);
        return ResponseEntity.ok(studentDto1);
    }

    //updateStudent
    @PutMapping
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto StudentDto) {
        StudentDto studentDto = studentService.updateStudent(StudentDto);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAllStudents() {
        List<StudentDto> studentDtoList = studentService.getAll();
        return ResponseEntity.ok(studentDtoList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteStudentById(@PathVariable Long id) {
        boolean isDeleted = studentService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<StudentDto> getStudentDtoById(@PathVariable Long id) {
        StudentDto studentDto = studentService.getById(id);
        return ResponseEntity.ok(studentDto);
    }

    @GetMapping("/findStudentById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student);
    }

}
