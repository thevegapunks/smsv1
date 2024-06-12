package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.ScholarLevelDto;
import com.digitechbb.smsv1.model.entities.ScholarLevel;

import java.util.List;

public interface ScholarLevelService {
    ScholarLevel saveScholarLevel(ScholarLevel scholarLevel);

    ScholarLevelDto saveScholarLevelDto(ScholarLevelDto scholarLevelDto);

    List<ScholarLevelDto> getAll();

    ScholarLevelDto updateScholarLevel(ScholarLevelDto scholarLevelDto);

    boolean delete(Long id);

    ScholarLevelDto getById(Long id);

    ScholarLevel getScholarLevelById(Long id);
}

