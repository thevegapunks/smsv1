package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.ProfessorDto;

import java.util.List;

public interface ProfessorService {
    ProfessorDto save(ProfessorDto professorDto);

    ProfessorDto updateProfessor(ProfessorDto professorDto);

    ProfessorDto getProfessor(Long id);

    List<ProfessorDto> getAllProfessors();

    boolean deleteProfessorById(Long id);

}
