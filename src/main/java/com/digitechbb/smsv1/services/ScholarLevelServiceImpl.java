package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.ScholarLevelDto;
import com.digitechbb.smsv1.model.entities.ScholarLevel;
import com.digitechbb.smsv1.mappers.ScholarLevelMapper;
import com.digitechbb.smsv1.repositories.ScholarLevelRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScholarLevelServiceImpl implements ScholarLevelService {

    private final ScholarLevelRepository scholarLevelRepository;
    private final ScholarLevelMapper scholarLevelMapper;

    public ScholarLevelServiceImpl(ScholarLevelRepository scholarLevelRepository, ScholarLevelMapper scholarLevelMapper) {
        this.scholarLevelRepository = scholarLevelRepository;
        this.scholarLevelMapper = scholarLevelMapper;
    }

    @Override
    public ScholarLevel saveScholarLevel(ScholarLevel scholarLevel) {
        return scholarLevelRepository.save(scholarLevel);
    }

    @Override
    public ScholarLevelDto saveScholarLevelDto(ScholarLevelDto scholarLevelDto) {
        ScholarLevel scholarLevel = scholarLevelMapper.toEntity(scholarLevelDto);
        scholarLevel = scholarLevelRepository.save(scholarLevel);
        return scholarLevelMapper.toDTO(scholarLevel);
    }

    @Override
    public List<ScholarLevelDto> getAll() {
        return scholarLevelRepository.findAll().stream()
                .map(scholarLevelMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ScholarLevelDto updateScholarLevel(ScholarLevelDto scholarLevelDto) {
        ScholarLevel scholarLevel = scholarLevelMapper.toEntity(scholarLevelDto);
        scholarLevel = scholarLevelRepository.save(scholarLevel);
        return scholarLevelMapper.toDTO(scholarLevel);
    }

    @Override
    public boolean delete(Long id) {
        if (scholarLevelRepository.existsById(id)) {
            scholarLevelRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public ScholarLevelDto getById(Long id) {
        return scholarLevelRepository.findById(id)
                .map(scholarLevelMapper::toDTO)
                .orElse(null);
    }

    @Override
    public ScholarLevel getScholarLevelById(Long id) {
        return scholarLevelRepository.findById(id).orElse(null);
    }
}

