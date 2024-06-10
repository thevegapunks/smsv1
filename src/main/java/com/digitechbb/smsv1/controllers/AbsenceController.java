package com.digitechbb.smsv1.controllers;

import com.digitechbb.smsv1.model.dtos.AbsenceDto;
import com.digitechbb.smsv1.services.AbsenceService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private ResponseEntity<AbsenceDto> save(@RequestBody AbsenceDto absenceDto){
        AbsenceDto absenceDto1 = absenceService.save(absenceDto);
//      return ResponseEntity.ok(absenceDto1);
      return new ResponseEntity<>(absenceDto1,HttpStatus.OK);
    }


    @GetMapping("{id}")
    private ResponseEntity<AbsenceDto> findById(@PathVariable Long id){
        AbsenceDto absenceDto = absenceService.findById(id);
        return new   ResponseEntity<>(absenceDto,HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<List<AbsenceDto>> getAll(){
        List<AbsenceDto> absenceDtoList = absenceService.getAll();
        if (absenceDtoList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return  new  ResponseEntity<>(absenceDtoList,HttpStatus.OK);
    }
    @PutMapping
    private ResponseEntity<AbsenceDto> update(@RequestBody AbsenceDto absenceDto){
        AbsenceDto absenceDto1 = absenceService.updateAbsence(absenceDto);
        return new ResponseEntity<>(absenceDto1,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    private ResponseEntity<HttpStatus> deleteById(@PathVariable Long id){
        boolean isDeleted = absenceService.deleteAbsenceById(id);
        if (isDeleted)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        else {
            return new  ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
