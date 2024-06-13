package com.digitechbb.smsv1.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @ManyToOne
    @JoinColumn(name = "professorId")
    private Professor professor;
    @ManyToOne
    @JoinColumn(name = "sessionId")
    private Session session; //the room is included in session class
    private String additionalInfo;


}
