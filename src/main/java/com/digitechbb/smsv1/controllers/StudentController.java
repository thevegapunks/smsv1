package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.entities.Student;
import com.digitechbb.smsv1.services.StudentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
@Slf4j
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class StudentController  {

    private StudentService studentService;

    @PostMapping
    public Student saveStudent(@RequestBody Student Student){
        return studentService.saveStudent(Student);
    }
    @PutMapping
    public Student updateStudent(@RequestBody Student Student){
        return studentService.updateStudent(Student);
    }


}
