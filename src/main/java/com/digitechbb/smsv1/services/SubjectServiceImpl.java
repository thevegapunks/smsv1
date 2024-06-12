package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.exception.ResourceNotFoundException;
import com.digitechbb.smsv1.mappers.SubjectMapper;
import com.digitechbb.smsv1.model.dtos.SubjectDto;
import com.digitechbb.smsv1.model.entities.Subject;
import com.digitechbb.smsv1.repositories.SubjectRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class SubjectServiceImpl implements SubjectService{
    private final SubjectRepository subjectRepository;
    private final SubjectMapper subjectMapper;


    @Override
    public SubjectDto save(SubjectDto subjectDto) {
        Subject subject = subjectMapper.toEntity(subjectDto) ;

        return subjectMapper.toDto(subjectRepository.save(subject));
    }

    @Override
    public SubjectDto update(SubjectDto subjectDto) {

        Subject subject = subjectRepository.findByReference(subjectDto.reference()).orElseThrow(() -> new ResourceNotFoundException("Not Found Subject with reference : " + subjectDto.reference()));
        Subject updatedSubject = subjectMapper.toEntity(subjectDto);
        updatedSubject.setId(subject.getId());

        return subjectMapper.toDto(subjectRepository.save(updatedSubject));
    }

    @Override
    public SubjectDto findById(Long id) {
        Subject subject = subjectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Subject with id : " + id));

        return subjectMapper.toDto(subject);
    }

    @Override
    public boolean deleteSubjectById(Long id) {
        subjectRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Not Found Subject with id : " + id));
        subjectRepository.deleteById(id);
        return true;
    }

    @Override
    public List<SubjectDto> getAll() {
       List<SubjectDto> subjectDtoList=  subjectRepository.findAll().stream().map(subjectMapper::toDto).collect(Collectors.toList());
        return subjectDtoList;
    }
}
