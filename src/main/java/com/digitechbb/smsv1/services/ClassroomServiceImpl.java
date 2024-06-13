package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.mappers.ClassroomMapper;
import com.digitechbb.smsv1.model.dtos.ClassroomDto;
import com.digitechbb.smsv1.model.entities.Classroom;
import com.digitechbb.smsv1.repositories.ClassroomRepository;
//import com.digitechbb.smsv1.services.ClassroomService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClassroomServiceImpl implements ClassroomService {


    private final ClassroomRepository classroomRepository;

    private final ClassroomMapper classroomMapper;

    @Override
    public ClassroomDto createClassroom(ClassroomDto classroomDto) {
        Classroom classroom = classroomMapper.toEntity(classroomDto);
        Classroom savedClassroom = classroomRepository.save(classroom);
        return classroomMapper.toDTO(savedClassroom);
    }

    @Override
    public ClassroomDto getClassroomById(Long id) {
        Optional<Classroom> classroom = classroomRepository.findById(id);
        return classroom.map(classroomMapper::toDTO).orElse(null);
    }

    @Override
    public List<ClassroomDto> getAllClassrooms() {
        List<Classroom> classrooms = classroomRepository.findAll();
        return classrooms.stream()
                .map(classroomMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClassroomDto updateClassroom(Long id, ClassroomDto classroomDto) {
        Optional<Classroom> existingClassroom = classroomRepository.findById(id);
        if (existingClassroom.isPresent()) {
            Classroom classroom = classroomMapper.toEntity(classroomDto);
            classroom.setId(id); // Ensure the ID is set for update
            Classroom updatedClassroom = classroomRepository.save(classroom);
            return classroomMapper.toDTO(updatedClassroom);
        }
        return null;
    }

    @Override
    public void deleteClassroom(Long id) {
        classroomRepository.deleteById(id);
    }
}
