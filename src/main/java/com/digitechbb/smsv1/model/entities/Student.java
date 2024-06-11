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
public class Student extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String studentNumber;
    private String schoolLevel;
    private String modeOfPayment;
    private LocalDate startDate;
    private String parentContact;
    @OneToMany(mappedBy = "student" , cascade = CascadeType.ALL)
    private List<Absence> absences;
}
