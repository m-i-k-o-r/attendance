package com.koroli.attendance.data.dto;

import com.koroli.attendance.data.dto.extra.StudentDtoOnlyInfo;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GroupDto {
    private Long id;
    private int number;
    private int course;
    private Set<StudentDtoOnlyInfo> students;
}
