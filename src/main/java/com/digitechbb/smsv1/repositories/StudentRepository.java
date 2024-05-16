package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface StudentRepository extends JpaRepository<Student,Long> {
}
