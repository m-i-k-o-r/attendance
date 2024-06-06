package com.koroli.attendance.data.dto;

import com.koroli.attendance.data.dto.extra.DisciplineDtoOnlyInfo;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDto {
    private UUID id;
    private LocalDateTime dateTime;
    private Set<Long> students;
    private DisciplineDtoOnlyInfo discipline;
}
