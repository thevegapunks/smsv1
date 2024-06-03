package com.digitechbb.smsv1.model.dtos;

import com.digitechbb.smsv1.enums.Gender;
import com.digitechbb.smsv1.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


import java.time.LocalDate;

public record StudentDto(
        String studentNumber,
        String firstName,
        String lastName,
        String address,
        Gender gender,
        LocalDate dateOfBirth,
        String email,
        String phone,
        Statut statut,
        String schoolLevel,
        String modeOfPayment,
        LocalDate startDate,
        String parentContact
) {
}
