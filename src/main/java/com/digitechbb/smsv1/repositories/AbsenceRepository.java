package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    Optional<Absence> findAbsenceByAbsenceNumber(String absenceNumber);
}
