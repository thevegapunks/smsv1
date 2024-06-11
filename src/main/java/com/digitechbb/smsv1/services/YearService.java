package com.digitechbb.smsv1.services;

import com.digitechbb.smsv1.model.dtos.YearDto;
import com.digitechbb.smsv1.model.entities.Year;
import com.digitechbb.smsv1.mappers.YearMapper;
import com.digitechbb.smsv1.repositories.YearRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class YearService {

        @Autowired
        private YearRepository yearRepository;

        @Autowired
        private YearMapper yearMapper;

        public List<YearDto> findAll() {
            return yearRepository.findAll().stream()
                    .map(yearMapper::toDTO)
                    .collect(Collectors.toList());
        }

        public YearDto findById(Long id) {
            return yearRepository.findById(id)
                    .map(yearMapper::toDTO)
                    .orElse(null);
        }

        public YearDto save(YearDto yearDTO) {
            Year year = yearMapper.toEntity(yearDTO);
            year = yearRepository.save(year);
            return yearMapper.toDTO(year);
        }

        public void deleteById(Long id) {
            yearRepository.deleteById(id);
        }
}
