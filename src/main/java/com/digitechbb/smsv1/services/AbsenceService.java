package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.AbsenceDto;

import java.util.List;

public interface AbsenceService {
    AbsenceDto save(AbsenceDto absenceDto);
    AbsenceDto updateAbsence(AbsenceDto absenceDto);
    List<AbsenceDto> getAll();
    AbsenceDto findById(Long id);
    void deleteAbsenceById(Long id);


}
