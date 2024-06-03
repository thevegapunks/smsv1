package com.digitechbb.smsv1.model.dtos;
import com.digitechbb.smsv1.enums.Fonction;
import com.digitechbb.smsv1.enums.Gender;
import com.digitechbb.smsv1.enums.Statut;
import java.time.LocalDate;

public record EmployeeDto(
         String cin,
         String firstName,
         String lastName,
         String address,
         Gender gender,
         LocalDate dateOfBirth,
         String email,
         String phone,
         Statut statut,
         String modeOfPayment,
         LocalDate startDate,
         Float salary,
         Fonction fonction,
         Long accountId
) {

}
