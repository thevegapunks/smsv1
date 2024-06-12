package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.SubjectDto;
import com.digitechbb.smsv1.model.entities.Subject;
import org.springframework.stereotype.Component;

@Component
public class SubjectMapperImpl implements SubjectMapper {
    @Override
    public Subject toEntity(SubjectDto subjectDto) {
        if (subjectDto == null) return null;
        Subject subject = new Subject();
        subject.setReference(subjectDto.reference());
        subject.setName(subjectDto.name());
        subject.setLevel(subjectDto.level());
        return subject;
    }
    @Override
    public SubjectDto toDto(Subject subject) {
        if (subject == null) return null;
        return new SubjectDto(
                subject.getReference(),
                subject.getName(),
                subject.getLevel()
        );
    }
}
