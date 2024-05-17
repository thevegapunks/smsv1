package com.digitechbb.smsv1.model.dtos;

import com.digitechbb.smsv1.enums.Statut;

import java.time.LocalDate;

public record ProfessorDto(
        String firstName,
        String lastName,
        String address,
        com.digitechbb.smsv1.enums.Gender Gender,
        LocalDate dateOfBirth,
        String email,
        String phone,
        Statut statut,
         String schoolLevel,
        String modeOfPayment,
        LocalDate startDate,
        Float salary
) {
}
