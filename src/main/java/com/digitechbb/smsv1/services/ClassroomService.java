package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.ClassroomDto;

import java.util.List;

public interface ClassroomService {
    ClassroomDto createClassroom(ClassroomDto classroomDto);
    ClassroomDto getClassroomById(Long id);
    List<ClassroomDto> getAllClassrooms();
    ClassroomDto updateClassroom(Long id, ClassroomDto classroomDto);
    void deleteClassroom(Long id);
}
