package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SubjectRepository extends JpaRepository<Subject,Long> {

Optional<Subject> findByReference(String ref);

}
