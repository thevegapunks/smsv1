package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.ScholarLevel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScholarLevelRepository extends JpaRepository<ScholarLevel,Long> {
}
