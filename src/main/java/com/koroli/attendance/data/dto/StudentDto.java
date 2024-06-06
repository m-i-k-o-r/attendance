package com.koroli.attendance.data.dto;

import com.koroli.attendance.data.dto.extra.GroupDtoOnlyInfo;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentDto {
    private Long idNumberCard;
    private String fullName;
    private GroupDtoOnlyInfo group;
}
