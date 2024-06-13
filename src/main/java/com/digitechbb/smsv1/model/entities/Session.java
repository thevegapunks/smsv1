package com.digitechbb.smsv1.model.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate sessionDay;
    private LocalTime startTime;
    private LocalTime endTime;
    @ManyToOne
    @JoinColumn(name = "subjectId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "classroomId")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Classroom classroom;
    @OneToMany(mappedBy = "session",cascade = CascadeType.ALL)
    private List<Assignment> assignments;

}
