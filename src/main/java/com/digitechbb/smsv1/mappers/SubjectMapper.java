package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.SubjectDto;
import com.digitechbb.smsv1.model.entities.Subject;

public interface SubjectMapper {
    Subject toEntity(SubjectDto subjectDto);

    SubjectDto toDto(Subject subject);
}
