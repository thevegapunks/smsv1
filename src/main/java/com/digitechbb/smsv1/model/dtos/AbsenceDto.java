package com.digitechbb.smsv1.model.dtos;

import java.time.LocalDate;
import java.time.LocalTime;

public record AbsenceDto(
         String absenceNumber,
         LocalDate date,
         LocalTime hour,
         int numberOfHour,
         String subject,
         String reason,
         Long studentId
) {
}
