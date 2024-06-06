package com.koroli.attendance.data.forms;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentForm {
    private Long idNumberCard;
    private String fullName;
    private Long groupId;
}
