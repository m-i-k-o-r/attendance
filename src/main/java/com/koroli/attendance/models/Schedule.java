package com.koroli.attendance.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue
    private UUID id;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private DayOfWeek weekday;
    private int frequency;

    @ManyToOne
    @JoinColumn(name = "discipline_id")
    private Discipline discipline;
}
