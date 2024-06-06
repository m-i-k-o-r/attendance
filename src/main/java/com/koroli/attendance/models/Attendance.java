package com.koroli.attendance.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "attendance")
public class Attendance {   
    @Id
    @GeneratedValue
    private UUID id;
    private LocalDateTime dateTime;
    private boolean isComplete;
    private String students;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
}
