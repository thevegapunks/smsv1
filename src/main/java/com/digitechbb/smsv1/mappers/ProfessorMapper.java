package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.ProfessorDto;
import com.digitechbb.smsv1.model.entities.Professor;

public interface ProfessorMapper {
    Professor toProfessor(ProfessorDto professorDto);
    ProfessorDto toDto(Professor professor);
}
