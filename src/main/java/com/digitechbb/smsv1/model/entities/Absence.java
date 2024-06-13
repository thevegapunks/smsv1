package com.digitechbb.smsv1.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String absenceNumber;
    private LocalDate date;
    private LocalTime hour;
    private int numberOfHour;
    //it is better to use session à la place de (subject+date+hour+numberOfHour)
    @ManyToOne
    @JoinColumn(name = "subjectId")
    private Subject subject;//switch it to Subject type and update the AbsenceMapper
    private String reason;
    @ManyToOne
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name ="studentId" )
    private Student student;

}
