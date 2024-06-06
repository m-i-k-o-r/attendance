package com.koroli.attendance.data.forms;

import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;

@Getter
@Setter
public class ScheduleForm {
    private LocalTime timeStart;
    private LocalTime timeEnd;
    private DayOfWeek weekday;
    private int frequency;
}
