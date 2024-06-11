package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.model.entities.Year;
import org.springframework.stereotype.Component;

@Component
public class YearMapperImpl implements YearMapper{
    @Override
    public YearDto toDTO(Year year) {
            if (year == null) return null;
        return new YearDto(
                year.getYear()
        );
    }

    @Override
    public Year toEntity(YearDto yearDTO) {
        if(yearDTO==null) return null;
        Year year = new Year();
        year.setYear(yearDTO.year());

        return year;
    }
}
