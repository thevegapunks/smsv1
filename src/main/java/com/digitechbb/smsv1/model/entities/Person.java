package com.digitechbb.smsv1.model.entities;

import com.digitechbb.smsv1.enums.Gender;
import com.digitechbb.smsv1.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class  Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate dateOfBirth;
    private String email;
    private String phone;
    @Enumerated(EnumType.STRING)
    private Statut statut;

}
