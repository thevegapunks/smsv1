package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.SubjectDto;

import java.util.List;

public interface SubjectService {
    SubjectDto save(SubjectDto subjectDto);
    SubjectDto update(SubjectDto subjectDto);
    SubjectDto findById(Long id);
    boolean deleteSubjectById(Long id);
    List<SubjectDto> getAll();

}
