package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.ProfessorDto;
import com.digitechbb.smsv1.services.ProfessorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/professors")
@Slf4j
@CrossOrigin(origins ={"http://localhost:4200", "http://localhost"})
@AllArgsConstructor
public class ProfessorController {

    private final ProfessorService professorService;

    @PostMapping
    ProfessorDto save(@RequestBody ProfessorDto professorDto){
        return professorService.save(professorDto);
    }
    @GetMapping
    List<ProfessorDto> getAllProfessors(){
        return professorService.getAllProfessors();
    }
    @GetMapping("{id}")
    ProfessorDto getProfessorById(@PathVariable Long id){
        return professorService.getProfessor(id);
    }
    @DeleteMapping("{id}")
    void deleteById(@PathVariable Long id){
        professorService.deleteProfessorById(id);
    }

    @PutMapping
    public ProfessorDto updateProfessor(@RequestBody ProfessorDto professorDto){
        return professorService.updateProfessor(professorDto);
    }

}
