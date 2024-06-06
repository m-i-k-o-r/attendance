package com.koroli.attendance.data.forms;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class DisciplineForm {
    private String name;
    private Long groupId;
    private UUID professorId;
}
