package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.model.entities.Year;
import com.digitechbb.smsv1.mappers.YearMapper;
import com.digitechbb.smsv1.repositories.YearRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YearServiceImpl implements YearService {

    private final YearRepository yearRepository;
    private final YearMapper yearMapper;

    public YearServiceImpl(YearRepository yearRepository, YearMapper yearMapper) {
        this.yearRepository = yearRepository;
        this.yearMapper = yearMapper;
    }

    @Override
    public Year saveYear(Year year) {
        return yearRepository.save(year);
    }

    @Override
    public YearDto saveYearDto(YearDto yearDto) {
        Year year = yearMapper.toEntity(yearDto);
        year = yearRepository.save(year);
        return yearMapper.toDTO(year);
    }

    @Override
    public List<YearDto> getAll() {
        return yearRepository.findAll().stream()
                .map(yearMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override  // this not an update it is an insert need to fixed
    public YearDto updateYear(YearDto yearDto) {
        Year year = yearMapper.toEntity(yearDto);
        year = yearRepository.save(year);
        return yearMapper.toDTO(year);
    }

    @Override
    public boolean delete(Long id) {
        // if (yearRepository.existsById(id)) {    //existsById call findById(id).isPresent();
        if (yearRepository.findById(id).isPresent()) {
            yearRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public YearDto getById(Long id) {
        return yearRepository.findById(id)
                .map(yearMapper::toDTO)
                .orElse(null);
    }

    @Override
    public Year getYearById(Long id) {
        return yearRepository.findById(id).orElse(null);
    }
}
