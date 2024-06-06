package com.koroli.attendance.data.dto.extra;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDtoOnlyInfo {
    private Long id;
    private int number;
    private int course;
}
