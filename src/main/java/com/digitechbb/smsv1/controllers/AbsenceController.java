package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.AbsenceDto;
import com.digitechbb.smsv1.services.AbsenceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/absences")
@Slf4j
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class AbsenceController {
    private AbsenceService absenceService;

    @PostMapping
    private AbsenceDto save(@RequestBody AbsenceDto absenceDto){
      return   absenceService.save(absenceDto);
    }


    @GetMapping("{id}")
    private AbsenceDto findById(@PathVariable Long id){
      return   absenceService.findById(id);
    }
    @GetMapping
    private List<AbsenceDto> getAll(){
        return   absenceService.getAll();
    }
    @PutMapping
    private AbsenceDto update(@RequestBody AbsenceDto absenceDto){
        return   absenceService.updateAbsence(absenceDto);
    }
    @DeleteMapping("{id}")
    private void deleteByid(@PathVariable Long id){
        absenceService.deleteAbsenceById(id);
    }

}
