package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.AbsenceMapper;
import com.digitechbb.smsv1.model.dtos.AbsenceDto;
import com.digitechbb.smsv1.model.entities.Absence;
import com.digitechbb.smsv1.repositories.AbsenceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AbsenceServiceImpl implements AbsenceService{

    private final AbsenceMapper absenceMapper;
    private final AbsenceRepository absenceRepository;

    @Override
    public AbsenceDto save(AbsenceDto absenceDto) {

        Absence absence=absenceMapper.toEntity(absenceDto);

        return absenceMapper.toDto(absenceRepository.save(absence));
    }

    @Override
    public AbsenceDto updateAbsence(AbsenceDto absenceDto) {
        Absence absence = absenceRepository.findAbsenceByAbsenceNumber(absenceDto.absenceNumber());
        if (absence==null) return null;
        Absence updatedEmployee = absenceMapper.toEntity(absenceDto);
        updatedEmployee.setId(absence.getId());

        return absenceMapper.toDto(absenceRepository.save(updatedEmployee));
    }

    @Override
    public List<AbsenceDto> getAll() {
//        List<Absence> absenceList = absenceRepository.findAll();
//        List<AbsenceDto> absenceDtosList = new ArrayList<>();
//        for (Absence a:   absenceList ) {
//            absenceDtosList.add(absenceMapper.toDto(a));
//        }

        return absenceRepository.findAll().stream().map(absence -> absenceMapper.toDto(absence)).collect(Collectors.toList());
    }

    @Override
    public AbsenceDto findById(Long id) {

        return absenceMapper.toDto(absenceRepository.findById(id).orElse(null));
    }

    @Override
    public void deleteAbsenceById(Long id) {
        absenceRepository.deleteById(id);
    }
}
