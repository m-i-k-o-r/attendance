package com.koroli.attendance.data.dto.extra;

import com.koroli.attendance.data.dto.GroupDto;
import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DisciplineDtoOnlyInfo {
    private UUID id;
    private String name;
    private GroupDto group;
    private ProfessorDtoOnlyInfo professor;
}