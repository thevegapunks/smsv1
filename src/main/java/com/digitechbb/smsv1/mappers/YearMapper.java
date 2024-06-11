package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.model.entities.Year;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface YearMapper {
    YearDto toDTO(Year year);
    Year toEntity(YearDto yearDTO);
}
