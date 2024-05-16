package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Optional<Professor> findById(Long id);
    void deleteById(Long id);
}
