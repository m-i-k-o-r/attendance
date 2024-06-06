package com.koroli.attendance.data.forms;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public class AttendanceForm {
    private LocalDateTime dateTime;
    private UUID disciplineId;
}
