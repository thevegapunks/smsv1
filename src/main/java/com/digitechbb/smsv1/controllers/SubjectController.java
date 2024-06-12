package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.SubjectDto;
import com.digitechbb.smsv1.services.SubjectService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class SubjectController {
    private SubjectService subjectService;

    @PostMapping
    private ResponseEntity<SubjectDto> save(@RequestBody SubjectDto subjectDto) {
        SubjectDto subjectDto1 = subjectService.save(subjectDto);
        return new ResponseEntity<>(subjectDto1, HttpStatus.OK);
    }

    @GetMapping
    private ResponseEntity<List<SubjectDto>> getAll() {
        List<SubjectDto> subjectDtoList = subjectService.getAll();
        if (subjectDtoList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(subjectDtoList, HttpStatus.OK);
    }

    @PutMapping
    private ResponseEntity<SubjectDto> update(@RequestBody SubjectDto subjectDto) {
        SubjectDto subjectDto1 = subjectService.update(subjectDto);
        return new ResponseEntity<>(subjectDto1, HttpStatus.OK);
    }

    @DeleteMapping("{id}")
    private ResponseEntity<HttpStatus> deleteById(@PathVariable Long id) {
        boolean isDeleted = subjectService.deleteSubjectById(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

