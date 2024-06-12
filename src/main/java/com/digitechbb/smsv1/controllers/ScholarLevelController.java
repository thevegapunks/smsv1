package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.ScholarLevelDto;
import com.digitechbb.smsv1.model.entities.ScholarLevel;
import com.digitechbb.smsv1.services.ScholarLevelService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/scholar-levels")
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class ScholarLevelController {

    private final ScholarLevelService scholarLevelService;

    @PostMapping("/saveScholarLevel")
    public ResponseEntity<ScholarLevel> saveScholarLevel(@RequestBody ScholarLevel scholarLevel) {
        ScholarLevel savedScholarLevel = scholarLevelService.saveScholarLevel(scholarLevel);
        return ResponseEntity.ok(savedScholarLevel);
    }

    @PostMapping("/saveScholarLevelDto")
    public ResponseEntity<ScholarLevelDto> saveScholarLevelDto(@RequestBody ScholarLevelDto scholarLevelDto) {
        ScholarLevelDto savedScholarLevelDto = scholarLevelService.saveScholarLevelDto(scholarLevelDto);
        return ResponseEntity.ok(savedScholarLevelDto);
    }

    @PutMapping
    public ResponseEntity<ScholarLevelDto> updateScholarLevel(@RequestBody ScholarLevelDto scholarLevelDto) {
        ScholarLevelDto updatedScholarLevelDto = scholarLevelService.updateScholarLevel(scholarLevelDto);
        return ResponseEntity.ok(updatedScholarLevelDto);
    }

    @GetMapping
    public ResponseEntity<List<ScholarLevelDto>> getAllScholarLevels() {
        List<ScholarLevelDto> scholarLevelDtoList = scholarLevelService.getAll();
        return ResponseEntity.ok(scholarLevelDtoList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteScholarLevelById(@PathVariable Long id) {
        boolean isDeleted = scholarLevelService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<ScholarLevelDto> getScholarLevelDtoById(@PathVariable Long id) {
        ScholarLevelDto scholarLevelDto = scholarLevelService.getById(id);
        return ResponseEntity.ok(scholarLevelDto);
    }

    @GetMapping("/findScholarLevelById/{id}")
    public ResponseEntity<ScholarLevel> getScholarLevelById(@PathVariable Long id) {
        ScholarLevel scholarLevel = scholarLevelService.getScholarLevelById(id);
        return ResponseEntity.ok(scholarLevel);
    }
}

