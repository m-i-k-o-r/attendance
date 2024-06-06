package com.koroli.attendance.data.dto.extra;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDtoOnlyInfo {
    private UUID id;
    private String fullName;
}
