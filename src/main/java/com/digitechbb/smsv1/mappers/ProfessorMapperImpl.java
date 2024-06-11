package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.ProfessorDto;
import com.digitechbb.smsv1.model.entities.Account;
import com.digitechbb.smsv1.model.entities.Professor;
import org.springframework.stereotype.Component;

@Component
public class ProfessorMapperImpl implements ProfessorMapper{

    @Override
    public Professor toProfessor(ProfessorDto professorDto) {
        Professor professor = new Professor();
        professor.setCin(professorDto.cin());
        professor.setFirstName(professorDto.firstName());
        professor.setLastName(professorDto.lastName());
        professor.setAddress(professorDto.address());
        professor.setGender(professorDto.gender());
        professor.setDateOfBirth(professorDto.dateOfBirth());
        professor.setEmail(professorDto.email());
        professor.setPhone(professorDto.phone());
        professor.setStatut(professorDto.statut());
        professor.setSchoolLevel(professorDto.schoolLevel());
        professor.setModeOfPayment(professorDto.modeOfPayment());
        professor.setStartDate(professorDto.startDate());
        professor.setSalary(professorDto.salary());
        professor.setAccount(professorDtoToAccount(professorDto));

        return professor;
    }

    protected Account professorDtoToAccount(ProfessorDto professorDto) {
        if (professorDto==null) return null;
        Account account = new Account();
        account.setId(professorDto.accountId());
        return account;
    }

    @Override
    public ProfessorDto toDto(Professor professor) {
        Long accountId = professorToAccountId(professor);
        return new ProfessorDto(
                professor.getCin(),
                professor.getFirstName(),
                professor.getLastName(),
                professor.getAddress(),
                professor.getGender(),
                professor.getDateOfBirth(),
                professor.getEmail(),
                professor.getPhone(),
                professor.getStatut(),
                professor.getSchoolLevel(),
                professor.getModeOfPayment(),
                professor.getStartDate(),
                professor.getSalary(),
                accountId
                
        );
    }

    private Long professorToAccountId(Professor professor) {
        if (professor==null) return null;
        Account account = professor.getAccount();
        if (account==null) return null;
        Long accountId = account.getId();
        return accountId;
    }

}
