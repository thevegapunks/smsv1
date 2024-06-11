package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.model.entities.Year;
import com.digitechbb.smsv1.services.YearService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/years")
@Slf4j
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class YearController {

    private final YearService yearService;

    @PostMapping("/saveYear")
    public ResponseEntity<Year> saveYear(@RequestBody Year year) {
        Year savedYear = yearService.saveYear(year);
        return ResponseEntity.ok(savedYear);
    }

    @PostMapping("/saveYearDto")
    public ResponseEntity<YearDto> saveYearDto(@RequestBody YearDto yearDto) {
        YearDto savedYearDto = yearService.saveYearDto(yearDto);
        return ResponseEntity.ok(savedYearDto);
    }

    @PutMapping
    public ResponseEntity<YearDto> updateYear(@RequestBody YearDto yearDto) {
        YearDto updatedYearDto = yearService.updateYear(yearDto);
        return ResponseEntity.ok(updatedYearDto);
    }

    @GetMapping
    public ResponseEntity<List<YearDto>> getAllYears() {
        List<YearDto> yearDtoList = yearService.getAll();
        return ResponseEntity.ok(yearDtoList);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteYearById(@PathVariable Long id) {
        boolean isDeleted = yearService.delete(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<YearDto> getYearDtoById(@PathVariable Long id) {
        YearDto yearDto = yearService.getById(id);
        return ResponseEntity.ok(yearDto);
    }

    @GetMapping("/findYearById/{id}")
    public ResponseEntity<Year> getYearById(@PathVariable Long id) {
        Year year = yearService.getYearById(id);
        return ResponseEntity.ok(year);
    }
}
