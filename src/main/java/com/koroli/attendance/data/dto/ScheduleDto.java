package com.koroli.attendance.data.dto;

import lombok.*;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {
    private UUID id;
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private DayOfWeek weekday;
    private int frequency;
}
