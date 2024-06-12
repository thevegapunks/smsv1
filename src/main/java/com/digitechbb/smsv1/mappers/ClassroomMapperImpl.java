package com.digitechbb.smsv1.mappers;

import com.digitechbb.smsv1.model.dtos.ClassroomDto;
import com.digitechbb.smsv1.model.entities.Classroom;
import org.springframework.stereotype.Component;

@Component
public class ClassroomMapperImpl implements ClassroomMapper {

    @Override
    public Classroom toEntity(ClassroomDto classroomDto) {
        if (classroomDto == null) {
            return null;
        }
        Classroom classroom = new Classroom();
        classroom.setNumber(classroomDto.number());  // Set the number
        classroom.setCapacity(classroomDto.capacity());  // Set the capacity
        classroom.setAvailability(classroomDto.availability());  // Set the availability
        return classroom;
    }

    @Override
    public ClassroomDto toDTO(Classroom classroom) {
        if (classroom == null) {
            return null;
        }
        return new ClassroomDto(
                classroom.getNumber(),  // Get the number
                classroom.getCapacity(),  // Get the capacity
                classroom.getAvailability()  // Get the availability
        );
    }
}
