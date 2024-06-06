package com.koroli.attendance.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "discipline")
public class Discipline {
    @Id
    @GeneratedValue
    private UUID id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    @ManyToOne
    @JoinColumn(name = "professor_id")
    private Professor professor;

    @OneToMany
    @JoinColumn(name = "discipline_id")
    private Set<Schedule> schedules;

    @OneToMany
    @JoinColumn(name = "discipline_id")
    private Set<Attendance> attendances;
}
