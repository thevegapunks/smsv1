package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.ClassroomDto;
import com.digitechbb.smsv1.services.ClassroomService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/classrooms")
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class ClassroomController {

    private  ClassroomService classroomService;

    @PostMapping
    public ResponseEntity<ClassroomDto> save(@RequestBody ClassroomDto classroomDto) {
        ClassroomDto savedClassroom = classroomService.createClassroom(classroomDto);
        return ResponseEntity.ok(savedClassroom);
    }

    @GetMapping
    public ResponseEntity<List<ClassroomDto>> getAllClassrooms() {
        List<ClassroomDto> classroomList = classroomService.getAllClassrooms();
        return ResponseEntity.ok(classroomList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClassroomDto> getById(@PathVariable Long id) {
        ClassroomDto classroomDto = classroomService.getClassroomById(id);
        return classroomDto != null ? ResponseEntity.ok(classroomDto) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        classroomService.deleteClassroom(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClassroomDto> updateClassroom(@PathVariable Long id, @RequestBody ClassroomDto classroomDto) {
        ClassroomDto updatedClassroom = classroomService.updateClassroom(id, classroomDto);
        return updatedClassroom != null ? ResponseEntity.ok(updatedClassroom) : ResponseEntity.notFound().build();
    }
}
