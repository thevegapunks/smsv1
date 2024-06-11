package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.ScholarLevelDto;
import com.digitechbb.smsv1.model.entities.ScholarLevel;

public interface ScholarLevelMapper {
    ScholarLevelDto toDTO(ScholarLevel scholarLevel);
    ScholarLevel toEntity(ScholarLevelDto scholarLevelDto);
}
