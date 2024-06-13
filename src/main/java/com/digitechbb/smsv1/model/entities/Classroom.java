package com.digitechbb.smsv1.model.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int number;
    private int capacity;
    private Boolean availability; // Changed to lowercase for better naming convention
    @OneToMany(mappedBy = "classroom" , cascade = CascadeType.ALL)
    List<Session> sessions;
}
