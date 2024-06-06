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
@Table(name = "professor")
public class Professor {
    @Id
    @GeneratedValue
    private UUID id;
    private String email;
    private String password;
    private String fullName;

    @OneToMany
    @JoinColumn(name = "professor_id")
    private Set<Discipline> disciplines;
}
