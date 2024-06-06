package com.koroli.attendance.data.dto.extra;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDtoOnlyInfo {
    private UUID id;
    private Long idNumberCard;
    private String fullName;
}
