package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.ProfessorDto;
import com.digitechbb.smsv1.services.ProfessorService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<ProfessorDto> save(@RequestBody ProfessorDto professorDto){
        ProfessorDto professorDto1 = professorService.save(professorDto);
        return ResponseEntity.ok(professorDto1);
    }
    @GetMapping
    ResponseEntity<List<ProfessorDto>> getAllProfessors(){
        List<ProfessorDto> professorDtoList = professorService.getAllProfessors();
        return ResponseEntity.ok(professorDtoList);
    }
    @GetMapping("{id}")
    ResponseEntity<ProfessorDto> getProfessorById(@PathVariable Long id){
        ProfessorDto professorDto = professorService.getProfessor(id);
        return ResponseEntity.ok(professorDto);
    }
    @DeleteMapping("{id}")
    ResponseEntity<Void> deleteById(@PathVariable Long id){

        boolean isDeleted = professorService.deleteProfessorById(id);

        if (isDeleted){
            return ResponseEntity.noContent().build();
        }else
            return ResponseEntity.notFound().build();
    }

    @PutMapping
    public ResponseEntity<ProfessorDto> updateProfessor(@RequestBody ProfessorDto professorDto){
        ProfessorDto professorDto1 = professorService.updateProfessor(professorDto);
        return ResponseEntity.ok(professorDto1);
    }
}
