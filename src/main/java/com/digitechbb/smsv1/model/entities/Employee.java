package com.digitechbb.smsv1.model.entities;

import com.digitechbb.smsv1.enums.Fonction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String cin;
    private String modeOfPayment;
    private LocalDate startDate;
    private Float salary;
    @Enumerated(EnumType.STRING)
    private Fonction fonction;
    @OneToOne
    @JoinColumn(name = "accountId")
    private Account account;

}
