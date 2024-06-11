package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.ScholarLevelDto;
import com.digitechbb.smsv1.model.entities.ScholarLevel;
import org.springframework.stereotype.Component;

@Component
public class ScholarLevelMapperImpl implements ScholarLevelMapper {

    @Override
    public ScholarLevelDto toDTO(ScholarLevel scholarLevel) {
        if (scholarLevel == null) return null;
        return new ScholarLevelDto(
                scholarLevel.getId(),
                scholarLevel.getName(),
                scholarLevel.getDescription()
        );
    }

    @Override
    public ScholarLevel toEntity(ScholarLevelDto scholarLevelDto) {
        if (scholarLevelDto == null) return null;
        ScholarLevel scholarLevel = new ScholarLevel();
        scholarLevel.setId(scholarLevelDto.id());
        scholarLevel.setName(scholarLevelDto.name());
        scholarLevel.setDescription(scholarLevelDto.description());
        return scholarLevel;
    }
}
