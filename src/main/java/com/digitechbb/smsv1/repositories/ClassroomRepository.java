package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassroomRepository extends JpaRepository<Classroom, Long> {
}
