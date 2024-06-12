package com.digitechbb.smsv1.repositories;

import com.digitechbb.smsv1.model.entities.Year;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearRepository extends JpaRepository<Year,Long> {
}
