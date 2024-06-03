package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence,Long> {
    Absence findAbsenceByAbsenceNumber(String absenceNumber);
}
