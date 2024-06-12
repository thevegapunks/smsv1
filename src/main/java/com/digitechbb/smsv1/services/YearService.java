package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.model.entities.Year;

import java.util.List;

public interface YearService {
    Year saveYear(Year year);

    YearDto saveYearDto(YearDto yearDto);

    List<YearDto> getAll();

    YearDto updateYear(YearDto yearDto);

    boolean delete(Long id);

    YearDto getById(Long id);

    Year getYearById(Long id);
}
