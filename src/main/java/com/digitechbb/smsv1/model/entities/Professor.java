package com.digitechbb.smsv1.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Professor extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String cin;
    private String schoolLevel;
    private String modeOfPayment;
    private LocalDate startDate;
    private Float salary;
    @OneToOne
    @JoinColumn(name = "accountId")
    private Account account;
    @OneToMany(mappedBy = "professor",cascade = CascadeType.ALL)
    private List<Assignment> assignments;
}
