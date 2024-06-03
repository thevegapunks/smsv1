package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.StudentDto;
import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@Slf4j
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class StudentController  {

    private StudentService studentService;

    @PostMapping("/saveStudent")
    public Student saveStudent(@RequestBody Student student){
        return studentService.saveStudent(student);
    }
    @PostMapping("saveStudentDto")
    public StudentDto saveStudentDto(@RequestBody StudentDto studentDto){
        return studentService.saveStudentDto(studentDto);
    }

    //updateStudent
    @PutMapping
    public StudentDto updateStudent(@RequestBody StudentDto StudentDto){
        return studentService.updateStudent(StudentDto);
    }

    @GetMapping
    public List<StudentDto> getAllStudents(){
        return studentService.getAll();
    }
    @DeleteMapping("{id}")
    public void deleteStudentById(@PathVariable Long id){
         studentService.delete(id);
    }

    @GetMapping("/findById/{id}")
    public StudentDto getStudentDtoById(@PathVariable Long id){
      return   studentService.getById(id);
    }

    @GetMapping("/findStudentById/{id}")
    public Student getStudentById(@PathVariable Long id){
        return   studentService.getStudentById(id);
    }

}
