package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.ClassroomDto;
import com.digitechbb.smsv1.model.entities.Classroom;

public interface ClassroomMapper {
    Classroom toEntity(ClassroomDto classroomDto);
    ClassroomDto toDTO(Classroom classroom);
}
