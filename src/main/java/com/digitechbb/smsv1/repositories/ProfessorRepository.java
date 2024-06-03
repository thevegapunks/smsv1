package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ProfessorRepository extends JpaRepository<Professor,Long> {
    Professor findProfessorByCin(String cin);
}
