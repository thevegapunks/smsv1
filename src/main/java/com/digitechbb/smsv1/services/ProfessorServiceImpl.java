package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.ProfessorMapper;
import com.digitechbb.smsv1.model.dtos.ProfessorDto;
import com.digitechbb.smsv1.model.entities.Professor;
import com.digitechbb.smsv1.repositories.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@AllArgsConstructor
public class ProfessorServiceImpl implements ProfessorService{
    private final ProfessorRepository professorRepository;
    private final ProfessorMapper professorMapper;

    @Override
    public ProfessorDto save(ProfessorDto professorDto) {
        return professorMapper.toDto(professorRepository.save(professorMapper.toProfessor(professorDto)));
    }

    @Override
    public ProfessorDto updateProfessor(ProfessorDto professorDto) {
        Professor professor = professorRepository.findProfessorByCin(professorDto.cin());
        if (professor == null)
            return null;
        Professor updatedProfessor = professorMapper.toProfessor(professorDto);
        updatedProfessor.setId(professor.getId());

        return professorMapper.toDto(professorRepository.save(updatedProfessor));
    }


    @Override
    public ProfessorDto getProfessor(Long id) {
        Professor professor = professorRepository.findById(id).orElse(null);
        if (professor==null)
            return null;
        return professorMapper.toDto(professor);
    }

    @Override
    public List<ProfessorDto> getAllProfessors() {
        List<Professor> professorList = professorRepository.findAll();
        if (professorList==null)
            return null;
        List<ProfessorDto> professorDtoList = new ArrayList<>();
        for (Professor p: professorList) {
            professorDtoList.add(professorMapper.toDto(p));
        }
        return professorDtoList;
    }

    @Override
    public void deleteProfessorById(Long id) {
        professorRepository.deleteById(id);
    }
}
