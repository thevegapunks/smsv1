package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.services.YearService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/years")

public class YearController {
    @Autowired
    private YearService yearService;

    @GetMapping
    public List<YearDto> getAllYears() {
        return yearService.findAll();
    }

    @GetMapping("/{id}")
    public YearDto getYearById(@PathVariable Long id) {
        return yearService.findById(id);
    }

    @PostMapping
    public YearDto createYear(@RequestBody YearDto yearDTO) {
        return yearService.save(yearDTO);
    }

    @PutMapping("/{id}")
    public YearDto updateYear(@PathVariable Long id, @RequestBody YearDto yearDTO) {
        yearDTO.setId(id);
        return yearService.save(yearDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteYear(@PathVariable Long id) {
        yearService.deleteById(id);
    }
}
