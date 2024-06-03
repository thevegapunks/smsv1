package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.AbsenceDto;
import com.digitechbb.smsv1.model.entities.Absence;

public interface AbsenceMapper {
    Absence toEntity(AbsenceDto absenceDto);
    AbsenceDto toDto(Absence absence);
}
