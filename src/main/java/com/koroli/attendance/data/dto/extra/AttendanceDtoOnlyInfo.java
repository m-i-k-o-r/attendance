package com.koroli.attendance.data.dto.extra;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttendanceDtoOnlyInfo {
    private UUID id;
    private LocalDateTime dateTime;
}