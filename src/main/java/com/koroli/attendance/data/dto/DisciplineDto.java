package com.koroli.attendance.data.dto;

import com.koroli.attendance.data.dto.extra.AttendanceDtoOnlyInfo;
import com.koroli.attendance.data.dto.extra.ProfessorDtoOnlyInfo;
import lombok.*;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineDto {
    private UUID id;
    private String name;
    private GroupDto group;
    private ProfessorDtoOnlyInfo professor;
    private Set<ScheduleDto> schedules;
    private Set<AttendanceDtoOnlyInfo> attendances;
}
