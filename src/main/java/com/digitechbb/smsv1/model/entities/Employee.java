package com.digitechbb.smsv1.model.entities;

import com.digitechbb.smsv1.enums.Function;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee extends Person{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ModeOfPayment;
    private LocalDate startDate;
    private Float salary;
    private Function function;

}
