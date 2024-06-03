package com.digitechbb.smsv1.model.entities;

import com.digitechbb.smsv1.enums.Statut;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String login;
    private String password;
    private Boolean activated;
    @Enumerated(EnumType.STRING)
    private Statut statut;
    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Professor professor;
    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Employee employee;

}
